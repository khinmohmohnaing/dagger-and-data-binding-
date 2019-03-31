package com.example.databinding

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.opengl.Visibility
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainView,BaseVH.onclick{
    override fun hideProgress() {
        progress.visibility=View.GONE
    }
    override fun showProgress() {
        progress.visibility= View.VISIBLE
    }

    override fun checkConnection():Boolean{
        val ConnectionManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = ConnectionManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected ) {
            isConnected = true
        }
        return isConnected
    }

    override fun onItemClick(position: Int) {
        var infoList=myadapter.getList(position)
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("weather", infoList.weather.get(0).description.toString())
        intent.putExtra("clouds", infoList.clouds.all.toString())
        intent.putExtra("wind", infoList.wind.speed.toString())
        intent.putExtra("date", infoList.dt_txt)
        intent.putExtra("image", "http://api.openweathermap.org/img/w/" +
                infoList.weather.get(0).icon)
        startActivity(intent)
    }

    override fun showWeather(weatherInfo:root) {
        Log.i("MainActivity","jdka;kfa")
        myadapter.addList(weatherInfo)
        weather_recycler.adapter = myadapter
        myadapter.notifyDataSetChanged()
        myadapter.setOnClick(this@MainActivity)
    }


    @Inject
    lateinit var mainPresenter: MainPresenter
    lateinit var myadapter:MyAdapter
    var isConnected =false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isConnected=checkConnection()
        myadapter= MyAdapter(this)
        weather_recycler.layoutManager = LinearLayoutManager(this)
        showProgress()
        mainPresenter.showWeatherInfo(this,16.871311, 96.199379)


        /*  AndroidInjection.inject(this)
          binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
              R.layout.activity_main
          )
          val temperatureData = UserInfo("Hamburg", "10")
          binding.setUserInfo(temperatureData)
  binding.setAppPresenter(jobListPresenter)
  */

        /*
         lateinit var api: mWeatherApiInterface

    lateinit var presenter:MainPresenter
    lateinit var myadapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        api = Get_Retrofit.getRetrofit().create(mWeatherApiInterface::class.java)
        weather_recycler.layoutManager = LinearLayoutManager(this)
        myadapter= MyAdapter(this)
        presenter = MainPresenter(this, MainIntearactor())
        isConnected=checkconnection(applicationContext)
        Log.i("isConnected",isConnected.toString())
        presenter.getInfo(isConnected)
        cityweatherbtn.setOnClickListener{presenter.gotoCity()}
    }
    override fun getWeatherInfo() {
        showProgress()
        val information = api.getweatherinfo(16.871311, 96.199379)

        information.enqueue(object : Callback<root> {
            override fun onResponse(call: Call<root>, response: Response<root>) {
                if (response.isSuccessful()) {
                    hideProgress()
                    myadapter.addList(response.body()!!)
                    weather_recycler.adapter = myadapter
                    myadapter.notifyDataSetChanged()
                    myadapter.setOnClick(this@MainActivity)
                } else
                    Log.e("MainActivity", "unsuccess")
            }

            override fun onFailure(call: Call<root>, t: Throwable) {
                Log.e("MainActivity", "fail")
            }

        })
    }
    override fun onItemClick(position: Int) {
        var infoList=myadapter.getList(position)
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("weather", infoList.weather.get(0).description.toString())
        intent.putExtra("clouds", infoList.clouds.all.toString())
        intent.putExtra("wind", infoList.wind.speed.toString())
        intent.putExtra("date", infoList.dt_txt)
        intent.putExtra("image", "http://api.openweathermap.org/img/w/" +
                infoList.weather.get(0).icon)
        startActivity(intent)
    }
    override fun checkconnection(context: Context): Boolean {
        val ConnectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = ConnectionManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected ) {
            isConnected = true
        }

        return isConnected
    }
    override fun showProgress() {
        progress.visibility= View.VISIBLE
    }
    override fun hideProgress() {
        progress.visibility=View.GONE
    }
    override fun showSnackBar() {
        val snackbar = Snackbar.make(mainlayout,
            "Check your connection", Snackbar.LENGTH_INDEFINITE)
            .setAction("Try Again",
                {isConnected=checkconnection(applicationContext)
                presenter.getInfo(isConnected)} )
        snackbar.show()
    }

    override fun gotoCityWeatherInfo() {
        val intent:Intent= Intent(applicationContext,CityWeatherActivity::class.java)
        startActivity(intent)
    }

}
         */
    }
}

