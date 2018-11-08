package com.haris.android.trade.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.haris.android.trade.domain.models.DomainCoin;
import com.haris.android.trade.presentation.R;
import com.haris.android.trade.presentation.internal.di.HasComponent;

import com.haris.android.trade.presentation.internal.di.components.DaggerTradeComponent;
import com.haris.android.trade.presentation.internal.di.components.TradeComponent;
import com.haris.android.trade.presentation.view.fragment.TradeFragment;

public class TradeActivity extends BaseActivity implements HasComponent<TradeComponent>, TradeFragment.CoinListListener {


    public static Intent getCallingIntent(Context context) {
        Intent callingIntent = new Intent(context, TradeActivity.class);
        return callingIntent;
    }

    private TradeComponent tradeComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_trade);

        this.initializeActivity();
        this.initializeInjector();

    }




    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        android.view.MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }


    private void initializeActivity() {
        addFragment(R.id.fragmentContainer, TradeFragment.forTrade());
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


    @Override
    protected void onPause() {
        super.onPause();

    }


    @Override
    public void onCoinClicked(DomainCoin.Coin coin) {
        this.navigator.navigateToChart(this, coin.getCoinCode());

    }
}



