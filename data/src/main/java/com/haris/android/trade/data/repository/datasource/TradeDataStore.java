
package com.haris.android.trade.data.repository.datasource;

import com.haris.android.trade.data.entity.CoinEntity;
import com.haris.android.trade.data.entity.GraphEntity;

import io.reactivex.Observable;


public interface TradeDataStore {


    Observable<CoinEntity> tradeDetails();

    Observable<GraphEntity> chartDetails(String currencyPair,String start, String end);


}
