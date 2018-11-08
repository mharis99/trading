
package com.haris.android.trade.presentation.internal.di.modules;

import android.content.Context;


import com.haris.android.trade.data.executor.JobExecutor;
import com.haris.android.trade.data.repository.TradeDataRepository;
import com.haris.android.trade.domain.executor.PostExecutionThread;
import com.haris.android.trade.domain.executor.ThreadExecutor;
import com.haris.android.trade.domain.repository.TradeRepository;
import com.haris.android.trade.presentation.AndroidApplication;
import com.haris.android.trade.presentation.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }


    @Provides
    @Singleton
    TradeRepository provideTradeRepository(TradeDataRepository tradeDataRepository) {
        return tradeDataRepository;
    }
}
