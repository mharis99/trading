
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
public class WeatherDetailsPresenterTest {

    private static final String FAKE_LAT = "25";

    private static final String FAKE_LNG = "55";

  private TradePresenter weatherDetailsPresenter;

  @Mock private Context mockContext;
  @Mock private TradeView mockWeatherDetailsView;
  @Mock private GetTradeDetails mockGetTradeDetails;
  @Mock private TradeModelDataMapper mockTradeModelDataMapper;

  @Before
  public void setUp() {
    weatherDetailsPresenter = new TradePresenter(mockGetTradeDetails, mockTradeModelDataMapper);
    weatherDetailsPresenter.setView(mockWeatherDetailsView);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testWeatherDetailsPresenterInitialize() {
    given(mockWeatherDetailsView.context()).willReturn(mockContext);

    //weatherDetailsPresenter.initialize(FAKE_LAT,FAKE_LNG,true);

    verify(mockWeatherDetailsView).hideRetry();
    verify(mockWeatherDetailsView).showLoading();
    verify(mockGetTradeDetails).execute(any(DisposableObserver.class), any(Params.class));
  }
}
