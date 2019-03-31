package com.example.databinding

import android.arch.lifecycle.LiveData
import io.reactivex.Single
import retrofit2.Call
import javax.inject.Inject

class  MainInteractImpl @Inject constructor(
    private val jobService: MainService
) : MainInteract {
    override fun getWeatherInfo(lat : Double?, lon :Double? ): Call<root> {
        return  jobService.getweatherinfo(lat,lon)
    }

}

