
package com.haris.android.trade.data.entity.mapper;

import com.google.gson.JsonSyntaxException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TradeEntityJsonMapperTest {

    private static String JSON_RESPONSE="{\"coord\":" +
     "{\"lon\":139.01,\"lat\":35.02}," +
      "\"trade\":" +
       "[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}]," +
        "\"base\":\"stations\",\"main\":" +
         "{\"temp\":285.514,\"pressure\":1013.75,\"humidity\":100,\"temp_min\":285.514,\"temp_max\":285.514,\"s" +
          "ea_level\":1023.22,\"grnd_level\":1013.75},\"wind\":" +
           "{\"speed\":5.52,\"deg\":311},\"clouds\":{\"all\":0},\"dt\":1485792967,\"sys\":" +
            "{\"message\":0.0025,\"country\":\"JP\",\"sunrise\":1485726240,\"sunset\":1485763863},\"" +
             "id\":1907296,\"name\":\"Tawarano\",\"cod\":200}";



    private TradeEntityJsonMapper tradeEntityJsonMapper;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        tradeEntityJsonMapper = new TradeEntityJsonMapper();
    }

    @Test
    public void testTransformWeatherEntityHappyCase() {
        //WeatherEntity weatherEntity = tradeEntityJsonMapper.transformCoinEntity(JSON_RESPONSE);

//        assertThat(weatherEntity.getId(), is(1));
//        assertThat(weatherEntity.getName(), is(equalTo("New York")));
    }



    @Test
    public void testTransformWeatherEntityNotValidResponse() {
        expectedException.expect(JsonSyntaxException.class);
        tradeEntityJsonMapper.transformCoinEntity("invalid_string");
    }


}
