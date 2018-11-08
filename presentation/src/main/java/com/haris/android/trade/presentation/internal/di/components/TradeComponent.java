
package com.haris.android.trade.presentation.internal.di.components;

import com.haris.android.trade.presentation.internal.di.PerActivity;
import com.haris.android.trade.presentation.internal.di.modules.ActivityModule;
import com.haris.android.trade.presentation.internal.di.modules.TradeModule;
import com.haris.android.trade.presentation.view.fragment.ChartFrament;
import com.haris.android.trade.presentation.view.fragment.TradeFragment;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, TradeModule.class})
public interface TradeComponent extends ActivityComponent {
    void inject(TradeFragment tradeFragment);
    void inject(ChartFrament chartFrament);
}
