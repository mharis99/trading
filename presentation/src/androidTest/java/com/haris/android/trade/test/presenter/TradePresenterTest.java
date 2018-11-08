
package com.haris.android.trade.test.presenter;

import android.content.Context;

import com.haris.android.trade.domain.interactor.GetTradeDetails;
import com.haris.android.trade.domain.interactor.GetTradeDetails.Params;
import com.haris.android.trade.presentation.mapper.TradeModelDataMapper;
import com.haris.android.trade.presentation.presenter.TradePresenter;
import com.haris.android.trade.presentation.view.TradeView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.observers.DisposableObserver;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TradePresenterTest {

  private TradePresenter tradePresenter;

  @Mock private Context mockContext;
  @Mock private TradeView tradeView;
  @Mock private GetTradeDetails mockGetTradeDetails;
  @Mock private TradeModelDataMapper mockTradeModelDataMapper;

  @Before
  public void setUp() {
    tradePresenter = new TradePresenter(mockGetTradeDetails, mockTradeModelDataMapper);
    tradePresenter.setView(tradeView);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testTradePresenterInitialize() {
    given(tradeView.context()).willReturn(mockContext);

    verify(tradeView).hideRetry();
    verify(tradeView).showLoading();
    verify(mockGetTradeDetails).execute(any(DisposableObserver.class), any(Params.class));
  }
}
