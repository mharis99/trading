
package com.haris.android.trade.data.repository.datasource;


import com.haris.android.trade.data.net.RestApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CloudTradeDataStoreTest {

    private static final String FAKE_LAT = "25";

    private static final String FAKE_LNG = "55";


    private CloudTradeDataStore cloudTradeDataStore;

    @Mock
    private RestApi mockRestApi;
//    @Mock
//    private WeatherCache mockWeatherCache;

    @Before
    public void setUp() {
        //cloudTradeDataStore = new CloudTradeDataStore(mockRestApi, mockWeatherCache);
    }



    @Test
    public void testGetWeatherEntityDetailsFromApi() {
//        WeatherEntity fakeWeatherEntity = new WeatherEntity();
//        Observable<WeatherEntity> fakeObservable = Observable.just(fakeWeatherEntity);
//        given(mockRestApi.tradeEntity(FAKE_LAT,FAKE_LNG)).willReturn(fakeObservable);
//
//        cloudTradeDataStore.tradeDetails(FAKE_LAT,FAKE_LNG);
//
//        verify(mockRestApi).tradeEntity(FAKE_LAT,FAKE_LNG);
    }


}
