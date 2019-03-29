package com.example.databinding

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [MainModule.Declarations::class])
object MainModule {
    @Provides
    @JvmStatic
    fun mainView(mainActivity: MainActivity): MainView = mainActivity
    @Module
    interface Declarations {
        @Binds
        fun mainPresenter(mainPresenterImpl: MainPresenterImpl): MainPresenter

        @Binds
        fun mainInteract(mainInteractImpl:MainInteractImpl):MainInteract
    }
}