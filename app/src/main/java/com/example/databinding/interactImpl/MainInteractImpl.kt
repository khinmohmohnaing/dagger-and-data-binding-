package com.example.databinding.interactImpl

import com.example.databinding.service.MainService
import com.example.databinding.interact.MainInteract
import com.example.databinding.model.root
import retrofit2.Call
import javax.inject.Inject

class  MainInteractImpl @Inject constructor(
    private val jobService: MainService
) : MainInteract {
    override fun getWeatherInfo(lat : Double?, lon :Double? ): Call<root> {
        return  jobService.getweatherinfo(lat,lon)
    }

}

