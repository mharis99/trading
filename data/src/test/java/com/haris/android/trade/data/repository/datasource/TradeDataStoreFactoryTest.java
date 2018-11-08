
package com.haris.android.trade.data.repository.datasource;

import com.haris.android.trade.data.ApplicationTestCase;
//import com.haris.android.trade.data.cache.WeatherCache;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.robolectric.RuntimeEnvironment;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class TradeDataStoreFactoryTest extends ApplicationTestCase {

  private static final int FAKE_WEATHER_ID = 11;

  private TradeDataStoreFactory tradeDataStoreFactory;

//  @Mock private WeatherCache mockWeatherCache;

  @Before
  public void setUp() {
   // tradeDataStoreFactory = new TradeDataStoreFactory(RuntimeEnvironment.application, mockWeatherCache);
  }

  @Test
  public void testCreateDiskDataStore() {
//    given(mockWeatherCache.isCached(FAKE_WEATHER_ID)).willReturn(true);
//    given(mockWeatherCache.isExpired()).willReturn(false);
//
//    TradeDataStore tradeDataStore = tradeDataStoreFactory.create(FAKE_WEATHER_ID);
//
//    assertThat(tradeDataStore, is(notNullValue()));
//    assertThat(tradeDataStore, is(instanceOf(DiskWeatherDataStore.class)));
//
//    verify(mockWeatherCache).isCached(FAKE_WEATHER_ID);
//    verify(mockWeatherCache).isExpired();
  }

  @Test
  public void testCreateCloudDataStore() {
//    given(mockWeatherCache.isExpired()).willReturn(true);
//    given(mockWeatherCache.isCached(FAKE_WEATHER_ID)).willReturn(false);
//
//    TradeDataStore tradeDataStore = tradeDataStoreFactory.create(FAKE_WEATHER_ID,true);
//
//    assertThat(tradeDataStore, is(notNullValue()));
//    assertThat(tradeDataStore, is(instanceOf(CloudTradeDataStore.class)));
//
//    verify(mockWeatherCache).isExpired();
  }
}
