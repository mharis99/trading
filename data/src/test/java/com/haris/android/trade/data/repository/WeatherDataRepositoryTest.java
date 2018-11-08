
package com.haris.android.trade.data.repository;

import com.haris.android.trade.data.entity.mapper.TradeEntityDataMapper;
import com.haris.android.trade.data.repository.datasource.TradeDataStore;
import com.haris.android.trade.data.repository.datasource.TradeDataStoreFactory;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WeatherDataRepositoryTest {

    private static final String FAKE_LAT = "25";
    private static final String FAKE_LNG = "55";

  private static final int FAKE_WEATHER_ID = 123;


  private TradeDataRepository weatherDataRepository;

  @Mock private TradeDataStoreFactory mockTradeDataStoreFactory;
  @Mock private TradeEntityDataMapper mockTradeEntityDataMapper;
  @Mock private TradeDataStore mockTradeDataStore;



  @Before
  public void setUp() {
    weatherDataRepository = new TradeDataRepository(mockTradeDataStoreFactory, mockTradeEntityDataMapper);
    //given(mockTradeDataStoreFactory.create(anyInt())).willReturn(mockTradeDataStore);
    given(mockTradeDataStoreFactory.createCloudDataStore()).willReturn(mockTradeDataStore);
  }



  @Test
  public void testGetWeatherHappyCase() {
//    WeatherEntity tradeEntity = new WeatherEntity();
//    given(mockTradeDataStore.tradeDetails(FAKE_LAT,FAKE_LNG)).willReturn(Observable.just(tradeEntity));
//    weatherDataRepository.trade(FAKE_LAT,FAKE_LNG);
//
//    verify(mockTradeDataStoreFactory).create(FAKE_WEATHER_ID);
//    verify(mockTradeDataStore).tradeDetails(FAKE_LAT,FAKE_LNG);
  }
}
