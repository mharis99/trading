package com.haris.android.trade.presentation.view.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.haris.android.trade.presentation.R;
import com.haris.android.trade.presentation.internal.di.components.TradeComponent;
import com.haris.android.trade.presentation.model.GraphModel;
import com.haris.android.trade.presentation.presenter.ChartPresenter;
import com.haris.android.trade.presentation.view.ChartView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.internal.Preconditions;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;


public class ChartFrament extends BaseFragment implements ChartView {
    private static final String PARAM_COIN_ID = "param_coin_id";

    @Inject
    ChartPresenter chartPresenter;


    @Bind(R.id.chart)
    LineChartView lineChartView;
    @Bind(R.id.rl_progress)
    RelativeLayout rl_progress;
    @Bind(R.id.rl_retry)
    RelativeLayout rl_retry;
    @Bind(R.id.bt_retry)
    Button bt_retry;

    private static long SIX_HOURS_IN_MILLIS = 2160000000l;
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");

    public static ChartFrament forChart(String coinId) {
        final ChartFrament chartFrament = new ChartFrament();
        final Bundle arguments = new Bundle();
        arguments.putString(PARAM_COIN_ID, coinId);
        chartFrament.setArguments(arguments);
        return chartFrament;
    }

    public ChartFrament() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(TradeComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_chart_frament, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.chartPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadChartDetails();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.chartPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.chartPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.chartPresenter.destroy();
    }

    @Override
    public void renderChart(GraphModel graphModel) {
        drawChart(graphModel);
    }

    @Override
    public void showLoading() {
        this.rl_progress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rl_retry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    /**
     * Load chart details.
     */
    private void loadChartDetails() {
        if (this.chartPresenter != null) {
            this.chartPresenter.initialize(currentCoinId(), String.valueOf((System.currentTimeMillis() - SIX_HOURS_IN_MILLIS) / 1000), String.valueOf(System.currentTimeMillis() / 1000), true);

            //this.chartPresenter.initialize(currentCoinId(), "1541376000","1541588584",  true);
        }
    }

    /**
     * Get current chart id from fragments arguments.
     */
    private String currentCoinId() {
        final Bundle arguments = getArguments();
        Preconditions.checkNotNull(arguments, "Fragment arguments cannot be null");
        return arguments.getString(PARAM_COIN_ID);
    }

    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        ChartFrament.this.loadChartDetails();
    }


    private void drawChart(GraphModel graphModel) {


        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));

        for (int i = 0; i < graphModel.getCoins().size(); i++) {
            Date date = new Date(graphModel.getCoins().get(i).getDate());
            DATE_FORMAT.format(date);
            axisValues.add(i, new AxisValue(i).setLabel(String.valueOf(DATE_FORMAT.format(date))));
            yAxisValues.add(new PointValue(i, Float.valueOf(String.valueOf(graphModel.getCoins().get(i).getVolume()))));
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(14);
        axis.setName("Time");
        axis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName("Volume");
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);

    }

}
