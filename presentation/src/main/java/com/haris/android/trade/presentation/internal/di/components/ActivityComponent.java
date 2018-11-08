
package com.haris.android.trade.presentation.internal.di.components;

import android.app.Activity;

import com.haris.android.trade.presentation.internal.di.PerActivity;
import com.haris.android.trade.presentation.internal.di.modules.ActivityModule;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
    Activity activity();
}
