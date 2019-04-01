package com.example.databinding.view.activity

import com.example.databinding.model.root

interface MainView {
    fun showProgress()
    fun hideProgress()
    fun showWeather(infoList: root)
    fun checkConnection():Boolean
}