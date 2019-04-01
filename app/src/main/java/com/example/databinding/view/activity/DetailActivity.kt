package com.example.databinding.view.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.databinding.R
import com.example.databinding.databinding.ActivityDetailBinding
import com.example.databinding.model.DetailInfo

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(
            this,
            R.layout.activity_detail
        )
        val intent = intent
        val detailInfo = DetailInfo(
            intent.getStringExtra("weather"),
            intent.getStringExtra("clouds"), intent.getStringExtra("wind"),
            intent.getStringExtra("date"), intent.getStringExtra("image")
        )
        binding.setDetailInfo(detailInfo)
    }
}
