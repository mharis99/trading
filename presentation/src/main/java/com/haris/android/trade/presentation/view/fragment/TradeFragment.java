package com.haris.android.trade.presentation.view.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.haris.android.trade.domain.models.DomainCoin;
import com.haris.android.trade.presentation.R;

import com.haris.android.trade.presentation.internal.di.components.TradeComponent;
import com.haris.android.trade.presentation.model.CoinModel;
import com.haris.android.trade.presentation.presenter.TradePresenter;
import com.haris.android.trade.presentation.view.TradeView;
import com.haris.android.trade.presentation.view.adapter.CoinsAdapter;
import com.haris.android.trade.presentation.view.adapter.CoinsLayoutManager;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TradeFragment extends BaseFragment implements TradeView {



    /**
     * Interface for listening coin list events.
     */
    public interface CoinListListener {
        void onCoinClicked(final DomainCoin.Coin coin);
    }


    @Inject
    TradePresenter tradePresenter;

    @Inject
    CoinsAdapter coinsAdapter;

    @Bind(R.id.rl_progress)
    RelativeLayout rl_progress;
    @Bind(R.id.rl_retry)
    RelativeLayout rl_retry;
    @Bind(R.id.bt_retry)
    Button bt_retry;


    @Bind(R.id.rv_coins)
    RecyclerView rv_coins;

    private CoinListListener coinListListener;


    public static TradeFragment forTrade() {
        return new TradeFragment();
    }

    public TradeFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(TradeComponent.class).inject(this);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_trade, container, false);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.tradePresenter.setView(this);
        this.loadTradeDetails(true);

    }

    @Override
    public void onResume() {
        super.onResume();
        this.tradePresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.tradePresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.tradePresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.coinListListener = null;
    }

    @Override
    public void renderTrade(CoinModel coinModel) {
        if (coinModel != null) {
            this.coinsAdapter.setCoins(coinModel.getCoins());
        }
    }

    @Override
    public void viewChart(DomainCoin.Coin coin) {

        if (this.coinListListener != null) {
            this.coinListListener.onCoinClicked(coin);
        }

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


    private void loadTradeDetails(boolean isForceUpdate) {

        if (this.tradePresenter != null) {
            this.tradePresenter.initialize(isForceUpdate);
        }
    }


    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        TradeFragment.this.loadTradeDetails( true);
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof CoinListListener) {
            this.coinListListener = (CoinListListener) activity;
        }
    }





    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {

        if (item.getItemId() == R.id.action_save) {

            TradeFragment.this.loadTradeDetails( true);

        }
        return super.onOptionsItemSelected(item);
    }


    private void setupRecyclerView() {
        this.coinsAdapter.setOnItemClickListener(onItemClickListener);
        CoinsLayoutManager coinsLayoutManager = new CoinsLayoutManager(context());
        this.rv_coins.setLayoutManager(coinsLayoutManager);
        this.rv_coins.setAdapter(coinsAdapter);



    }


    private CoinsAdapter.OnItemClickListener onItemClickListener =
            new CoinsAdapter.OnItemClickListener() {
                @Override
                public void onCoinItemClicked(DomainCoin.Coin coin) {

                    if (TradeFragment.this.tradePresenter != null && coin != null) {
                        TradeFragment.this.tradePresenter.onCoinClicked(coin);
                    }
                }
            };



}

