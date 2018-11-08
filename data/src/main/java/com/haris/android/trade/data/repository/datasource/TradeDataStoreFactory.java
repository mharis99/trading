
package com.haris.android.trade.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;


import com.haris.android.trade.data.net.RestApi;
import com.haris.android.trade.data.net.retrofit.RetrofitRestApiImpl;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class TradeDataStoreFactory {

    private final Context context;


    @Inject
    TradeDataStoreFactory(@NonNull Context context) {
        this.context = context.getApplicationContext();

    }


    public TradeDataStore create(boolean isForceCloudUpdate) {
        TradeDataStore tradeDataStore;

        tradeDataStore = createCloudDataStore();

        return tradeDataStore;
    }


    public TradeDataStore createCloudDataStore() {
        final RestApi restApi = new RetrofitRestApiImpl();
        return new CloudTradeDataStore(restApi);
    }
}
