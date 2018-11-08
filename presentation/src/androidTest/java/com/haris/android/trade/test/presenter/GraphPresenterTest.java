package com.haris.android.trade.test.presenter;

import android.content.Context;

import com.haris.android.trade.domain.interactor.GetChartDetail;
import com.haris.android.trade.domain.interactor.GetTradeDetails;
import com.haris.android.trade.presentation.mapper.TradeModelDataMapper;
import com.haris.android.trade.presentation.presenter.ChartPresenter;
import com.haris.android.trade.presentation.view.ChartView;

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
public class GraphPresenterTest {

    private ChartPresenter chartPresenter;

    @Mock
    private Context mockContext;
    @Mock private ChartView chartView;
    @Mock private GetChartDetail getChartDetail;
    @Mock private TradeModelDataMapper mockTradeModelDataMapper;

    @Before
    public void setUp() {
        chartPresenter = new ChartPresenter(getChartDetail, mockTradeModelDataMapper);
        chartPresenter.setView(chartView);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGraphPresenterInitialize() {
        given(chartView.context()).willReturn(mockContext);

        verify(chartView).hideRetry();
        verify(chartView).showLoading();
        verify(getChartDetail).execute(any(DisposableObserver.class), any(GetChartDetail.Params.class));
    }
}
