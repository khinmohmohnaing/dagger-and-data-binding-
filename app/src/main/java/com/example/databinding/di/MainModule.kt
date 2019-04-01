package com.example.databinding.di

import com.example.databinding.presenter.MainPresenter
import com.example.databinding.presenterImpl.MainPresenterImpl
import com.example.databinding.view.activity.MainView
import com.example.databinding.interact.MainInteract
import com.example.databinding.interactImpl.MainInteractImpl
import com.example.databinding.view.activity.MainActivity
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
        fun mainInteract(mainInteractImpl: MainInteractImpl): MainInteract
    }
}