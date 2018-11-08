
package com.haris.android.trade.domain;



import com.haris.android.trade.domain.models.DomainCoin;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TradeTest {

  private static final String FAKE_COIN_ID = "BTC_XMR";

  private DomainCoin trade;

  @Before
  public void setUp() {
    trade = new DomainCoin();
    List<DomainCoin.Coin> coins=new ArrayList<>();
    coins.add(new DomainCoin.Coin(FAKE_COIN_ID));
    trade.setCoins(coins);



  }

  @Test
  public void testTradeConstructorHappyCase() {
    final String coinCode = trade.getCoins().get(0).getCoinCode();

    assertThat(coinCode).isEqualTo(FAKE_COIN_ID);
  }
}
