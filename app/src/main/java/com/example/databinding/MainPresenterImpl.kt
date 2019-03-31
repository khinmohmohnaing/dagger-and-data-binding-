package com.example.databinding

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.content.Context
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    val view: MainView
): MainPresenter {


    @Inject
    lateinit var mainInteract: MainInteract

    override fun showWeatherInfo(context: LifecycleOwner, lat: Double?, lon: Double?) {
        mainInteract.getWeatherInfo(lat, lon)
            .enqueue(object : Callback<root>{
                override fun onResponse(call: Call<root>?, response: Response<root>?) {
                   if(view.checkConnection()){
                       view.hideProgress()
                       view.showWeather(response?.body()!!)
                   }else{
                       view.showProgress()
                   }
                }
                override fun onFailure(call: Call<root>?, t: Throwable?) {
                    //
                }
            })
    }
}