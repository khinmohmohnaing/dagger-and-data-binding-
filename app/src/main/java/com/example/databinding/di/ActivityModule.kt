package com.example.databinding.di

import com.example.databinding.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ContributesAndroidInjector(modules = [MainModule::class])
    fun mainActivity(): MainActivity
}