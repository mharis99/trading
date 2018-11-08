
package com.haris.android.trade.test.mapper;

import com.haris.android.trade.domain.models.DomainCoin;
import com.haris.android.trade.domain.models.DomainGraph;
import com.haris.android.trade.presentation.mapper.TradeModelDataMapper;
import com.haris.android.trade.presentation.model.CoinModel;
import com.haris.android.trade.presentation.model.GraphModel;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TradeModelDataMapperTest extends TestCase {

  private static final String FAKE_COIN_ID = "BTC_XMR";

  private static final Double FAKE_VOLUME = 233.36D;


  private TradeModelDataMapper tradeModelDataMapper;

  @Override protected void setUp() throws Exception {
    super.setUp();
    tradeModelDataMapper = new TradeModelDataMapper();
  }

  public void testTransformTrade() {
    DomainCoin trade = createFakeTrade();
    CoinModel coinModel = tradeModelDataMapper.transform(trade);

    assertThat(coinModel, is(instanceOf(CoinModel.class)));
    assertThat(coinModel.getCoins().get(0).getCoinCode(), is(FAKE_COIN_ID));

  }

  public void testTransformGraph() {
    DomainGraph fakeGraph = createFakeGraph();
    GraphModel coinModel = tradeModelDataMapper.transformGraphData(fakeGraph);

    assertThat(coinModel, is(instanceOf(GraphModel.class)));
    assertThat(coinModel.getCoins().get(0).getVolume(), is(FAKE_VOLUME));

  }




  private DomainCoin createFakeTrade() {
    DomainCoin trade = new DomainCoin();
    List<DomainCoin.Coin> coins=new ArrayList<>();
    coins.add(new DomainCoin.Coin(FAKE_COIN_ID));
    trade.setCoins(coins);

    return trade;
  }


  private DomainGraph createFakeGraph() {
    DomainGraph domainGraph = new DomainGraph();
    List<DomainGraph.GraphDataObj> graphDataObjs=new ArrayList<>();

    graphDataObjs.add(new DomainGraph.GraphDataObj(FAKE_VOLUME));

    domainGraph.setCoins(graphDataObjs);

    return domainGraph;
  }
}
