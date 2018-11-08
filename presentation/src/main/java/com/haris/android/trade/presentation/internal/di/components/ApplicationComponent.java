
package com.haris.android.trade.presentation.internal.di.components;

import android.content.Context;

import com.haris.android.trade.domain.executor.PostExecutionThread;
import com.haris.android.trade.domain.executor.ThreadExecutor;
import com.haris.android.trade.domain.repository.TradeRepository;
import com.haris.android.trade.presentation.view.activity.BaseActivity;
import com.haris.android.trade.presentation.internal.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);


    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    TradeRepository tradeRepository();
}
