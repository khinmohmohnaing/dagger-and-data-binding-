package com.example.databinding

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
object AppModule {
    @Provides
    @JvmStatic
    fun applicationContext(app: App): Context = app
}