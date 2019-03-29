package com.example.databinding

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject



class MainActivity : DaggerAppCompatActivity(), MainView {


    @Inject
    lateinit var jobListPresenter: MainPresenter




    override fun add(location: String) {
        Log.i("dkajkd",location)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jobListPresenter.loadInitData()


        /*  AndroidInjection.inject(this)
          binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
              R.layout.activity_main
          )
          val temperatureData = UserInfo("Hamburg", "10")
          binding.setUserInfo(temperatureData)
  binding.setAppPresenter(jobListPresenter)
  */
    }
}

