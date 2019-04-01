package com.example.databinding.presenterImpl

import android.arch.lifecycle.LifecycleOwner
import com.example.databinding.view.activity.MainView
import com.example.databinding.interact.MainInteract
import com.example.databinding.model.root
import com.example.databinding.presenter.MainPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    val view: MainView
) : MainPresenter {


    @Inject
    lateinit var mainInteract: MainInteract

    override fun showWeatherInfo(context: LifecycleOwner, lat: Double?, lon: Double?) {
        mainInteract.getWeatherInfo(lat, lon)
            .enqueue(object : Callback<root> {
                override fun onResponse(call: Call<root>?, response: Response<root>?) {
                    if (view.checkConnection()) {
                        view.hideProgress()
                        view.showWeather(response?.body()!!)
                    } else {
                        view.showProgress()
                    }
                }

                override fun onFailure(call: Call<root>?, t: Throwable?) {

                }
            })
    }
}