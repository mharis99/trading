package com.haris.android.trade.domain.interactor;

import com.haris.android.trade.domain.executor.PostExecutionThread;
import com.haris.android.trade.domain.executor.ThreadExecutor;
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
public class GetChartDetailsTest {

    private static final String FAKE_CURRENCY_PAIR = "BTC_XMR";
    private static final String FAKE_START_TIME = "1539498578";
    private static final String FAKE_END_TIME = "1541658578";

    private GetChartDetail getChartDetail;

    @Mock
    private TradeRepository mockTradeRepository;
    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        getChartDetail = new GetChartDetail(mockTradeRepository, mockThreadExecutor,
                mockPostExecutionThread);
    }

    @Test
    public void testGetChartDetailsUseCaseObservableHappyCase() {
        getChartDetail.buildUseCaseObservable(GetChartDetail.Params.forChart(FAKE_CURRENCY_PAIR,FAKE_START_TIME,FAKE_END_TIME,true));

        verify(mockTradeRepository).trade(anyBoolean());
        verifyNoMoreInteractions(mockTradeRepository);
        verifyZeroInteractions(mockPostExecutionThread);
        verifyZeroInteractions(mockThreadExecutor);
    }

    @Test
    public void testShouldFailWhenNoOrEmptyParameters() {
        expectedException.expect(NullPointerException.class);
        getChartDetail.buildUseCaseObservable(null);
    }
}