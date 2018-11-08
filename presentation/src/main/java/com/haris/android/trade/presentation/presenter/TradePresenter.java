package com.haris.android.trade.presentation.presenter;

import android.support.annotation.NonNull;

import com.haris.android.trade.domain.interactor.GetTradeDetails;
import com.haris.android.trade.domain.models.DomainCoin;
import com.haris.android.trade.domain.exception.DefaultErrorBundle;
import com.haris.android.trade.domain.exception.ErrorBundle;
import com.haris.android.trade.domain.interactor.DefaultObserver;

import com.haris.android.trade.presentation.mapper.TradeModelDataMapper;
import com.haris.android.trade.presentation.model.CoinModel;
import com.haris.android.trade.presentation.timer.TradeInterval;
import com.haris.android.trade.presentation.timer.TradeTimer;
import com.haris.android.trade.presentation.exception.ErrorMessageFactory;
import com.haris.android.trade.presentation.internal.di.PerActivity;

import com.haris.android.trade.presentation.view.TradeView;

import javax.inject.Inject;


@PerActivity
public class TradePresenter implements Presenter, TradeInterval {

    private TradeView viewDetailsView;

    private final GetTradeDetails getTradeDetailsUseCase;
    private final TradeModelDataMapper tradeModelDataMapper;
    private TradeTimer tradeTimer;

    @Inject
    public TradePresenter(GetTradeDetails getTradeDetailsUseCase, TradeModelDataMapper tradeModelDataMapper) {
        this.getTradeDetailsUseCase = getTradeDetailsUseCase;
        this.tradeModelDataMapper = tradeModelDataMapper;
    }

    public void setView(@NonNull TradeView view) {
        this.viewDetailsView = view;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    public void onCoinClicked(DomainCoin.Coin coin) {
        this.viewDetailsView.viewChart(coin);
    }

    @Override
    public void destroy() {
        this.getTradeDetailsUseCase.dispose();
        this.viewDetailsView = null;
        this.tradeTimer.cancel();
    }


    public void initialize(boolean isForceUpdate) {
        this.hideViewRetry();
        this.showViewLoading();
        this.tradeTimer = new TradeTimer(this);
        this.getTradeDetails(isForceUpdate);

        this.getTradeDetails(true);

    }

    private void getTradeDetails(boolean isForceUpdate) {
        this.getTradeDetailsUseCase.execute(new TradeDetailsObserver(), GetTradeDetails.Params.forTrade(isForceUpdate));
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

    private void showTradeDetailsInView(DomainCoin domainCoin) {
        final CoinModel coinModel = this.tradeModelDataMapper.transform(domainCoin);
        this.viewDetailsView.renderTrade(coinModel);
    }

    @Override
    public void onTradeIntervalUpdate() {

        this.getTradeDetails(true);

    }

    private final class TradeDetailsObserver extends DefaultObserver<DomainCoin> {

        @Override
        public void onComplete() {
            TradePresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            TradePresenter.this.hideViewLoading();
            TradePresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            TradePresenter.this.showViewRetry();
        }

        @Override
        public void onNext(DomainCoin domainCoin) {
            TradePresenter.this.showTradeDetailsInView(domainCoin);
        }
    }


}










