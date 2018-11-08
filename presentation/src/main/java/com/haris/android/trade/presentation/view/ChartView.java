package com.haris.android.trade.presentation.view;

import com.haris.android.trade.presentation.model.GraphModel;

public interface ChartView extends LoadDataView {

    void renderChart(GraphModel graphModel);
}
