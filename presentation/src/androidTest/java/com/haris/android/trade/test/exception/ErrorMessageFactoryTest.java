
package com.haris.android.trade.test.exception;

import android.test.AndroidTestCase;

import com.haris.android.trade.data.exception.TradeNotAvailableException;
import com.haris.android.trade.data.exception.NetworkConnectionException;
import com.haris.android.trade.presentation.R;
import com.haris.android.trade.presentation.exception.ErrorMessageFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ErrorMessageFactoryTest extends AndroidTestCase {

  @Override protected void setUp() throws Exception {
    super.setUp();
  }

  public void testNetworkConnectionErrorMessage() {
    String expectedMessage = getContext().getString(R.string.exception_message_no_connection);
    String actualMessage = ErrorMessageFactory.create(getContext(),
        new NetworkConnectionException());

    assertThat(actualMessage, is(equalTo(expectedMessage)));
  }

  public void testTradeNotFoundErrorMessage() {
    String expectedMessage = getContext().getString(R.string.exception_message_trade_not_found);
    String actualMessage = ErrorMessageFactory.create(getContext(), new TradeNotAvailableException());

    assertThat(actualMessage, is(equalTo(expectedMessage)));
  }
}
