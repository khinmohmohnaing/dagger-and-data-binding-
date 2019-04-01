package com.example.databinding.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.example.databinding.ViewHolderEvenListener
import com.example.databinding.model.WeatherInfo

abstract class BaseVH(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
    abstract fun bind(itemlist: WeatherInfo, onclicklistener: ViewHolderEvenListener, position: Int)
}