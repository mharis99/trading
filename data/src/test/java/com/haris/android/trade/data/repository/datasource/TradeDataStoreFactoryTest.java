
package com.haris.android.trade.data.repository.datasource;

import com.haris.android.trade.data.ApplicationTestCase;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class TradeDataStoreFactoryTest extends ApplicationTestCase {

  private TradeDataStoreFactory tradeDataStoreFactory;



  @Before
  public void setUp() {
    tradeDataStoreFactory = new TradeDataStoreFactory(RuntimeEnvironment.application);
  }



  @Test
  public void testCreateCloudDataStore() {


    TradeDataStore tradeDataStore = tradeDataStoreFactory.create(true);

    assertThat(tradeDataStore, is(notNullValue()));
    assertThat(tradeDataStore, is(instanceOf(CloudTradeDataStore.class)));


  }
}
