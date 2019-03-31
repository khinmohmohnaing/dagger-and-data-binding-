package com.example.databinding

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.databinding.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this,
            R.layout.activity_detail
        )
        val intent=intent
        val temperatureData = DetailInfo(intent.getStringExtra("weather"),
            intent.getStringExtra("clouds"),intent.getStringExtra("wind"),
            intent.getStringExtra("date"),intent.getStringExtra("image"))
        binding.setDetailInfo(temperatureData)
        //binding.set("https://androidwave.com/wp-content/uploads/2019/01/profile_pic.jpg");

       /* detailweathers.text=intent.getStringExtra("weather")
        detailclouds.text=intent.getStringExtra("clouds")
        detailwinds.text=intent.getStringExtra("wind")
        detaildates.text=intent.getStringExtra("date")
        Glide.with(this).load(intent.getStringExtra("image")).into(detailimg)*/
    }
}
