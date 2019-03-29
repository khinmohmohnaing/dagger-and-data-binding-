package com.example.databinding

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ContributesAndroidInjector(modules = [MainModule::class])
    fun mainActivity(): MainActivity
}