package com.haris.android.trade.data.net.retrofit;

import com.google.gson.JsonElement;
import com.haris.android.trade.data.net.RestApi;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TradeRetrofitApi {


    @GET(RestApi.TRADE)
    Map<String, Object> getTradeDetails();


    @GET(RestApi.CHART)
    JsonElement getChartDetails(@Query("currencyPair") String currencyPair,@Query("start") String start,@Query("end") String end);

}
