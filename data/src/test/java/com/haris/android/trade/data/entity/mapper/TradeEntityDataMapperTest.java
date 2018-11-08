
package com.haris.android.trade.data.entity.mapper;

import com.haris.android.trade.data.entity.CoinEntity;
import com.haris.android.trade.domain.models.DomainCoin;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class TradeEntityDataMapperTest {

  private static final String FAKE_COIN_ID = "BTC_XMR";


  private TradeEntityDataMapper tradeEntityDataMapper;

  @Before
  public void setUp() throws Exception {
    tradeEntityDataMapper = new TradeEntityDataMapper();
  }

  @Test
  public void testTransformCoinEntity() {
    CoinEntity tradeEntity = createFakeCoinEntity();
    DomainCoin trade = tradeEntityDataMapper.transform(tradeEntity);

    assertThat(trade, is(instanceOf(DomainCoin.class)));
    assertThat(trade.getCoins().get(0).getCoinCode(), is(FAKE_COIN_ID));

  }



  private CoinEntity createFakeCoinEntity() {
    CoinEntity tradeEntity = new CoinEntity();


    Map<String, Object> map=new HashMap<>();

    map.put(FAKE_COIN_ID,new Object());

    tradeEntity.setCoins(map);

    return tradeEntity;
  }
}
