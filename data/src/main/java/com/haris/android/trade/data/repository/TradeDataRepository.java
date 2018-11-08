
package com.haris.android.trade.data.repository;

import com.haris.android.trade.data.entity.mapper.TradeEntityDataMapper;
import com.haris.android.trade.data.repository.datasource.TradeDataStore;
import com.haris.android.trade.data.repository.datasource.TradeDataStoreFactory;
import com.haris.android.trade.domain.models.DomainCoin;
import com.haris.android.trade.domain.models.DomainGraph;
import com.haris.android.trade.domain.repository.TradeRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class TradeDataRepository implements TradeRepository {

    private final TradeDataStoreFactory tradeDataStoreFactory;
    private final TradeEntityDataMapper tradeEntityDataMapper;


    @Inject
    TradeDataRepository(TradeDataStoreFactory dataStoreFactory,
                        TradeEntityDataMapper tradeEntityDataMapper) {
        this.tradeDataStoreFactory = dataStoreFactory;
        this.tradeEntityDataMapper = tradeEntityDataMapper;
    }


    @Override
    public Observable<DomainCoin> trade(boolean isForceUpdate) {
        final TradeDataStore tradeDataStore = this.tradeDataStoreFactory.createCloudDataStore();
        return tradeDataStore.tradeDetails().map(this.tradeEntityDataMapper::transform);
    }

    @Override
    public Observable<DomainGraph> chartDetails(String currencyPair,String start, String end, boolean isForceUpdate) {
        final TradeDataStore tradeDataStore = this.tradeDataStoreFactory.createCloudDataStore();
        return tradeDataStore.chartDetails(currencyPair,start,end).map(this.tradeEntityDataMapper::transformGraphData);
    }
}
