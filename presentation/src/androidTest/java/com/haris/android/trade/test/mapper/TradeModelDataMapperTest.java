
package com.haris.android.trade.test.mapper;

import com.haris.android.trade.presentation.mapper.TradeModelDataMapper;

import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TradeModelDataMapperTest extends TestCase {

  private static final int FAKE_WEATHER_ID = 123;
  private static final String FAKE_NAME = "Latvia";

  private TradeModelDataMapper tradeModelDataMapper;

  @Override protected void setUp() throws Exception {
    super.setUp();
    tradeModelDataMapper = new TradeModelDataMapper();
  }

  public void testTransformWeather() {
//    DomainWeather trade = createFakeWeather();
//    WeatherModel weatherModel = tradeModelDataMapper.transform(trade);
//
//    assertThat(weatherModel, is(instanceOf(WeatherModel.class)));
//    assertThat(weatherModel.getId(), is(FAKE_WEATHER_ID));
//    assertThat(weatherModel.getName(), is(FAKE_NAME));
  }



//  private DomainWeather createFakeWeather() {
//    DomainWeather trade = new DomainWeather(FAKE_WEATHER_ID);
//    trade.setName(FAKE_NAME);
//
//    return trade;
//  }
}
