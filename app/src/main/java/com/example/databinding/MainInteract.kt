package com.example.databinding

import android.arch.lifecycle.LiveData
import io.reactivex.Single
import retrofit2.Call
import javax.inject.Inject

interface MainInteract {
 fun getWeatherInfo (lat:Double?,lon :Double?): Call<root>
}