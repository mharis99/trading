
package com.haris.android.trade.data.repository;

import com.haris.android.trade.data.entity.CoinEntity;
import com.haris.android.trade.data.entity.GraphEntity;
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
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TradeDataRepositoryTest {

  private static final String FAKE_CURRENCY_PAIR = "BTC_XMR";
  private static final String FAKE_START_TIME = "1539498578";
  private static final String FAKE_END_TIME = "1541658578";


  private TradeDataRepository tradeDataRepository;

  @Mock private TradeDataStoreFactory mockTradeDataStoreFactory;
  @Mock private TradeEntityDataMapper mockTradeEntityDataMapper;
  @Mock private TradeDataStore mockTradeDataStore;



  @Before
  public void setUp() {
    tradeDataRepository = new TradeDataRepository(mockTradeDataStoreFactory, mockTradeEntityDataMapper);
    given(mockTradeDataStoreFactory.create(anyBoolean())).willReturn(mockTradeDataStore);
    given(mockTradeDataStoreFactory.createCloudDataStore()).willReturn(mockTradeDataStore);
  }



  @Test
  public void testGetTradeHappyCase() {
    CoinEntity tradeEntity = new CoinEntity();
    given(mockTradeDataStore.tradeDetails()).willReturn(Observable.just(tradeEntity));
    tradeDataRepository.trade(anyBoolean());

    verify(mockTradeDataStoreFactory).create(anyBoolean());
    verify(mockTradeDataStore).tradeDetails();
  }


  @Test
  public void testGetGraphHappyCase() {
    GraphEntity tradeEntity = new GraphEntity();
    given(mockTradeDataStore.chartDetails(FAKE_CURRENCY_PAIR,FAKE_START_TIME,FAKE_END_TIME)).willReturn(Observable.just(tradeEntity));
    tradeDataRepository.chartDetails(FAKE_CURRENCY_PAIR,FAKE_START_TIME,FAKE_END_TIME,anyBoolean());

    verify(mockTradeDataStoreFactory).create(anyBoolean());
    verify(mockTradeDataStore).chartDetails(FAKE_CURRENCY_PAIR,FAKE_START_TIME,FAKE_END_TIME);
  }
}
