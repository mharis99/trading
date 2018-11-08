package com.haris.android.trade.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.haris.android.trade.presentation.R;
import com.haris.android.trade.presentation.internal.di.HasComponent;
import com.haris.android.trade.presentation.internal.di.components.DaggerTradeComponent;
import com.haris.android.trade.presentation.internal.di.components.TradeComponent;
import com.haris.android.trade.presentation.view.fragment.ChartFrament;

public class ChartActivity extends BaseActivity implements HasComponent<TradeComponent> {

    private static final String INTENT_EXTRA_PARAM_COIN_ID = "com.haris.android.INTENT_PARAM_COIN_ID";

    public static Intent getCallingIntent(Context context, String coinId) {
        Intent callingIntent = new Intent(context, ChartActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_COIN_ID, coinId);
        return callingIntent;
    }

    private String coinId;
    private TradeComponent tradeComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chart);

        this.initializeActivity();
        this.initializeInjector();

        setTitle(this.coinId);
    }

    /**
     * Initializes this activity.
     */
    private void initializeActivity() {
        this.coinId = getIntent().getStringExtra(INTENT_EXTRA_PARAM_COIN_ID);
        addFragment(R.id.fragmentContainer, ChartFrament.forChart(coinId));
    }

    private void initializeInjector() {
        this.tradeComponent = DaggerTradeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public TradeComponent getComponent() {
        return tradeComponent;
    }
}
