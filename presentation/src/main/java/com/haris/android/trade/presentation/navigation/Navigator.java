
package com.haris.android.trade.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.haris.android.trade.presentation.view.activity.ChartActivity;
import com.haris.android.trade.presentation.view.activity.LoginActivity;
import com.haris.android.trade.presentation.view.activity.TradeActivity;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class Navigator {

    @Inject
    public Navigator() {
        //empty
    }

    public void navigateToTrade(Context context) {
        if (context != null) {

            Intent intentToLaunch = TradeActivity.getCallingIntent(context);

            //Intent intentToLaunch = new Intent(context,LoginActivity.class);
            context.startActivity(intentToLaunch);
        }
    }

    public void navigateToChart(Context context,String coinId) {
        if (context != null) {

            Intent intentToLaunch = ChartActivity.getCallingIntent(context,coinId);
            context.startActivity(intentToLaunch);
        }
    }


}
