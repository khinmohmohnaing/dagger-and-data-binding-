package com.example.databinding.di

import android.content.Context
import com.example.databinding.App
import dagger.Module
import dagger.Provides


@Module
object AppModule {
    @Provides
    @JvmStatic
    fun applicationContext(app: App): Context = app
}