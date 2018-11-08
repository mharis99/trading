package com.haris.android.trade.presentation.view.activity;

import android.os.Bundle;
import android.widget.Button;

import com.haris.android.trade.presentation.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @Bind(R.id.btn_showTrade)
    Button btn_checkTrade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }



    @OnClick(R.id.btn_showTrade)
    void navigateToTradeDetails() {
        this.navigator.navigateToTrade(this);
    }

}
