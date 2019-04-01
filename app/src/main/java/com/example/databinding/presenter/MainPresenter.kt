package com.example.databinding.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context

interface MainPresenter {
    fun showWeatherInfo( context:LifecycleOwner,lat :Double?, lon :Double?)
}