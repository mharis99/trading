package com.haris.android.trade.presentation.presenter;

import android.support.annotation.NonNull;

import com.haris.android.trade.domain.exception.DefaultErrorBundle;
import com.haris.android.trade.domain.exception.ErrorBundle;
import com.haris.android.trade.domain.interactor.DefaultObserver;
import com.haris.android.trade.domain.interactor.GetChartDetail;
import com.haris.android.trade.domain.models.DomainGraph;
import com.haris.android.trade.presentation.exception.ErrorMessageFactory;
import com.haris.android.trade.presentation.mapper.TradeModelDataMapper;

import com.haris.android.trade.presentation.model.GraphModel;
import com.haris.android.trade.presentation.view.ChartView;

import javax.inject.Inject;

public class ChartPresenter implements Presenter {


    private ChartView viewDetailsView;

    private final GetChartDetail getChartDetail;
    private final TradeModelDataMapper tradeModelDataMapper;


    @Inject
    public ChartPresenter(GetChartDetail getChartDetail, TradeModelDataMapper tradeModelDataMapper) {
        this.getChartDetail = getChartDetail;
        this.tradeModelDataMapper = tradeModelDataMapper;
    }

    public void setView(@NonNull ChartView view) {
        this.viewDetailsView = view;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
        this.getChartDetail.dispose();
        this.viewDetailsView = null;

    }


    public void initialize(String currencyPair,String start, String end, boolean isForceUpdate) {
        this.hideViewRetry();
        this.showViewLoading();
        this.getChartDetails(currencyPair,start,end, true);

    }

    private void getChartDetails(String currencyPair,String start, String end, boolean isForceUpdate) {
        this.getChartDetail.execute(new ChartDetailsObserver(), GetChartDetail.Params.forChart(currencyPair,start,end, isForceUpdate));
    }

    private void showViewLoading() {
        this.viewDetailsView.showLoading();
    }

    private void hideViewLoading() {
        this.viewDetailsView.hideLoading();
    }

    private void showViewRetry() {
        this.viewDetailsView.showRetry();
    }

    private void hideViewRetry() {
        this.viewDetailsView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.viewDetailsView.context(), errorBundle.getException());
        this.viewDetailsView.showError(errorMessage);
    }

    private void showChartDetailsInView(DomainGraph domainGraph) {
        final GraphModel graphModel = this.tradeModelDataMapper.transformGraphData(domainGraph);
        this.viewDetailsView.renderChart(graphModel);
    }


    private final class ChartDetailsObserver extends DefaultObserver<DomainGraph> {

        @Override
        public void onComplete() {
            ChartPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            ChartPresenter.this.hideViewLoading();
            ChartPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            ChartPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(DomainGraph domainGraph) {
            ChartPresenter.this.showChartDetailsInView(domainGraph);
        }
    }






}
