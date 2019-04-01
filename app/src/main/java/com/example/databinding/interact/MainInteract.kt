package com.example.databinding.interact

import com.example.databinding.model.root
import retrofit2.Call

interface MainInteract {
 fun getWeatherInfo (lat:Double?,lon :Double?): Call<root>
}