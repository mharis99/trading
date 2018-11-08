
package com.haris.android.trade.data.repository.datasource;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DiskTradeDataStoreTest {

  private static final String FAKE_LAT = "25";

  private static final String FAKE_LNG = "55";


  //private DiskWeatherDataStore diskWeatherDataStore;

  //@Mock private WeatherCache mockWeatherCache;

  @Rule public ExpectedException expectedException = ExpectedException.none();

//  @Before
//  public void setUp() {
//    diskWeatherDataStore = new DiskWeatherDataStore(mockWeatherCache);
//  }

  @Test
  public void testGetWeatherEntityListUnsupported() {
    expectedException.expect(UnsupportedOperationException.class);
//    diskWeatherDataStore.tradeDetails(FAKE_LAT,FAKE_LNG);
  }

  @Test
  public void testGetWeatherEntityDetailesFromCache() {
//    diskWeatherDataStore.tradeDetails(FAKE_LAT,FAKE_LNG);
//    verify(mockWeatherCache).get(FAKE_LAT,FAKE_LNG);
  }
}
