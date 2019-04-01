package com.example.databinding

import dagger.android.HasActivityInjector
import dagger.android.support.DaggerApplication
import android.databinding.DataBindingUtil
import com.example.databinding.databindingcomponent.MyComponent
import com.example.databinding.di.AppComponent
import com.example.databinding.di.DaggerAppComponent


class App : DaggerApplication(),
    HasActivityInjector {
    override fun applicationInjector(): AppComponent {
        return DaggerAppComponent.builder()
            .application(this)
            .build()

    }

    override fun onCreate() {
        super.onCreate()
        applicationInjector().inject(this)
        DataBindingUtil.setDefaultComponent(MyComponent())
    }
}
