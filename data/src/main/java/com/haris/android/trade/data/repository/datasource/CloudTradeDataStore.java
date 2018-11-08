
package com.haris.android.trade.data.repository.datasource;


import com.haris.android.trade.data.entity.CoinEntity;
import com.haris.android.trade.data.entity.GraphEntity;

import com.haris.android.trade.data.net.RestApi;

import io.reactivex.Observable;


class CloudTradeDataStore implements TradeDataStore {

    private final RestApi restApi;

    CloudTradeDataStore(RestApi restApi) {
        this.restApi = restApi;

    }


    @Override
    public Observable<CoinEntity> tradeDetails() {
        return this.restApi.tradeEntity();
    }


    @Override
    public Observable<GraphEntity> chartDetails(String currencyPair,String start, String end) {
        return this.restApi.chartDetails(currencyPair,start,end);
    }

}
