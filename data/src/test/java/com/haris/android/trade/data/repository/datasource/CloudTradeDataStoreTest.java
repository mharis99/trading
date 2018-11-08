
package com.haris.android.trade.data.repository.datasource;


import com.haris.android.trade.data.entity.CoinEntity;
import com.haris.android.trade.data.entity.GraphEntity;
import com.haris.android.trade.data.net.RestApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class CloudTradeDataStoreTest {

    private static final String FAKE_CURRENCY_PAIR = "BTC_XMR";
    private static final String FAKE_START_TIME = "1539498578";
    private static final String FAKE_END_TIME = "1541658578";


    private CloudTradeDataStore cloudTradeDataStore;

    @Mock
    private RestApi mockRestApi;


    @Before
    public void setUp() {
        cloudTradeDataStore = new CloudTradeDataStore(mockRestApi);
    }



    @Test
    public void testGetTradeEntityDetailsFromApi() {
        CoinEntity fakeCoinEntity = new CoinEntity();
        Observable<CoinEntity> fakeObservable = Observable.just(fakeCoinEntity);
        given(mockRestApi.tradeEntity()).willReturn(fakeObservable);

        cloudTradeDataStore.tradeDetails();

        verify(mockRestApi).tradeEntity();
    }


    @Test
    public void testGetChartDetailsFromApi() {
        GraphEntity fakeGraphEntity = new GraphEntity();
        Observable<GraphEntity> fakeObservable = Observable.just(fakeGraphEntity);
        given(mockRestApi.chartDetails(FAKE_CURRENCY_PAIR,FAKE_START_TIME,FAKE_END_TIME)).willReturn(fakeObservable);

        cloudTradeDataStore.chartDetails(FAKE_CURRENCY_PAIR,FAKE_START_TIME,FAKE_END_TIME);

        verify(mockRestApi).chartDetails(FAKE_CURRENCY_PAIR,FAKE_START_TIME,FAKE_END_TIME);
    }


}
