package com.example.databinding

interface MainView {
    fun showProgress()
    fun hideProgress()
    fun showWeather(infoList: root)
    fun checkConnection():Boolean
}