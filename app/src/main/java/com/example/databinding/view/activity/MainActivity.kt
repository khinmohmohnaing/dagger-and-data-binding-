package com.example.databinding.view.activity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.databinding.*
import com.example.databinding.adapter.MyAdapter
import com.example.databinding.model.root
import com.example.databinding.presenter.MainPresenter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainView,
    ViewHolderEvenListener {
    override fun onClick(position: Int) {
        var infoList = myadapter.getList(position)
        Log.i("Click", "click")
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("weather", infoList.weather.get(0).description.toString())
        intent.putExtra("clouds", infoList.clouds.all.toString())
        intent.putExtra("wind", infoList.wind.speed.toString())
        intent.putExtra("date", infoList.dt_txt)
        intent.putExtra(
            "image", "http://api.openweathermap.org/img/w/" +
                    infoList.weather.get(0).icon
        )
        startActivity(intent)
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun checkConnection(): Boolean {
        val ConnectionManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = ConnectionManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            isConnected = true
        }
        return isConnected
    }

    override fun showWeather(weatherInfo: root) {
        Log.i("MainActivity", "jdka;kfa")
        myadapter.addList(weatherInfo)
        weather_recycler.adapter = myadapter
        myadapter.notifyDataSetChanged()
        myadapter.setOnClick(this@MainActivity)
    }


    @Inject
    lateinit var mainPresenter: MainPresenter
    lateinit var myadapter: MyAdapter
    var isConnected = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isConnected = checkConnection()
        myadapter = MyAdapter(this)
        weather_recycler.layoutManager = LinearLayoutManager(this)
        showProgress()
        mainPresenter.showWeatherInfo(this, 16.871311, 96.199379)
    }
}

