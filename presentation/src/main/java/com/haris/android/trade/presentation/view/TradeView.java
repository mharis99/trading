package com.haris.android.trade.presentation.view;

import com.haris.android.trade.domain.models.DomainCoin;
import com.haris.android.trade.presentation.model.CoinModel;

public interface TradeView extends LoadDataView {

    void renderTrade(CoinModel coinModel);

    void viewChart(DomainCoin.Coin coin);
}
