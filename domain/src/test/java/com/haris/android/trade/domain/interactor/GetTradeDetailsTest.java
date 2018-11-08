
package com.haris.android.trade.domain.interactor;

import com.haris.android.trade.domain.executor.PostExecutionThread;
import com.haris.android.trade.domain.executor.ThreadExecutor;
import com.haris.android.trade.domain.interactor.GetTradeDetails.Params;
import com.haris.android.trade.domain.repository.TradeRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class GetTradeDetailsTest {


  private GetTradeDetails getTradeDetails;

  @Mock private TradeRepository mockTradeRepository;
  @Mock private ThreadExecutor mockThreadExecutor;
  @Mock private PostExecutionThread mockPostExecutionThread;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setUp() {
    getTradeDetails = new GetTradeDetails(mockTradeRepository, mockThreadExecutor,
        mockPostExecutionThread);
  }

  @Test
  public void testGetTradeDetailsUseCaseObservableHappyCase() {
    getTradeDetails.buildUseCaseObservable(Params.forTrade(true));

    verify(mockTradeRepository).trade(anyBoolean());
    verifyNoMoreInteractions(mockTradeRepository);
    verifyZeroInteractions(mockPostExecutionThread);
    verifyZeroInteractions(mockThreadExecutor);
  }

  @Test
  public void testShouldFailWhenNoOrEmptyParameters() {
    expectedException.expect(NullPointerException.class);
    getTradeDetails.buildUseCaseObservable(null);
  }
}
