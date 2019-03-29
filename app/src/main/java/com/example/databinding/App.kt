package com.example.databinding

import android.app.Activity
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class App: DaggerApplication(),
    HasActivityInjector {
    override fun applicationInjector():AppComponent {
        return DaggerAppComponent.builder()
            .application(this)
            .build()

    }

    /* @Inject
     lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

     override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
         return dispatchingAndroidInjector
     }*/
    override fun onCreate() {
        super.onCreate()
        applicationInjector().inject(this)
    }
}
