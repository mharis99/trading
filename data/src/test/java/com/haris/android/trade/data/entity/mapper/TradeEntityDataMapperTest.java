
package com.haris.android.trade.data.entity.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;



import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class TradeEntityDataMapperTest {

  private static final int FAKE_WEATHER_ID = 123;
  private static final String FAKE_NAME = "Karachi";

  private TradeEntityDataMapper tradeEntityDataMapper;

  @Before
  public void setUp() throws Exception {
    tradeEntityDataMapper = new TradeEntityDataMapper();
  }

  @Test
  public void testTransformWeatherEntity() {
//    WeatherEntity tradeEntity = createFakeWeatherEntity();
//    DomainWeather trade = tradeEntityDataMapper.transform(tradeEntity);
//
//    assertThat(trade, is(instanceOf(DomainWeather.class)));
//    assertThat(trade.getId(), is(FAKE_WEATHER_ID));
//    assertThat(trade.getName(), is(FAKE_NAME));
  }



//  private WeatherEntity createFakeWeatherEntity() {
//    WeatherEntity tradeEntity = new WeatherEntity();
//    tradeEntity.setId(FAKE_WEATHER_ID);
//    tradeEntity.setName(FAKE_NAME);
//
//    return tradeEntity;
//  }
}
