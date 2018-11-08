
package com.haris.android.trade.data.net;

import com.haris.android.trade.data.entity.CoinEntity;
import com.haris.android.trade.data.entity.GraphEntity;

import io.reactivex.Observable;


public interface RestApi {

    String API_BASE_URL = "https://poloniex.com/";

    String TRADE = "public?command=returnTicker";

    String CHART = "public?command=returnChartData&period=14400";

    Observable<CoinEntity> tradeEntity();

    Observable<GraphEntity> chartDetails(String currencyPair, String start, String end);

}
