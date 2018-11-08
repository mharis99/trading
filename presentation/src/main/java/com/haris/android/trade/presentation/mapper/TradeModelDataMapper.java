package com.haris.android.trade.presentation.mapper;

import com.haris.android.trade.domain.models.DomainCoin;

import com.haris.android.trade.domain.models.DomainGraph;
import com.haris.android.trade.presentation.internal.di.PerActivity;
import com.haris.android.trade.presentation.model.CoinModel;
import com.haris.android.trade.presentation.model.GraphModel;

import javax.inject.Inject;


@PerActivity
public class TradeModelDataMapper {

    @Inject
    public TradeModelDataMapper() {
    }

    public CoinModel transform(DomainCoin domainCoin) {
        if (domainCoin == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final CoinModel coinModel = new CoinModel();

        coinModel.setCoins(domainCoin.getCoins());

        return coinModel;
    }


    public GraphModel transformGraphData(DomainGraph domainGraph) {
        if (domainGraph == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final GraphModel graphModel = new GraphModel();

        graphModel.setCoins(domainGraph.getCoins());
        
        return graphModel;
    }


}

