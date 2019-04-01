package com.example.databinding.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.databinding.*
import com.example.databinding.base.BaseVH
import com.example.databinding.databinding.WeatherItemBinding
import com.example.databinding.model.InfoList
import com.example.databinding.model.WeatherInfo
import com.example.databinding.model.root
import com.example.databinding.viewholder.WeatherViewHolder


class MyAdapter(context: Context) : RecyclerView.Adapter<BaseVH>() {

    lateinit var rootInfo: root
    lateinit var onClickItem: ViewHolderEvenListener

    fun addList(rootInfo: root) {
        this.rootInfo = rootInfo
        Log.i("size", rootInfo.list.size.toString())
    }

    fun getList(position: Int): InfoList {
        return rootInfo.list.get(position)
    }

    fun setOnClick(onClickItem: ViewHolderEvenListener) {
        this.onClickItem = onClickItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BaseVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<WeatherItemBinding>(
            layoutInflater,
            R.layout.weather_item, parent, false
        )
        return WeatherViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return rootInfo.list.size
    }

    override fun onBindViewHolder(holder: BaseVH, position: Int) {
        val weatherInfo = WeatherInfo(
            position, rootInfo.list.get(position).weather.get(0).description,
            rootInfo.list.get(position).clouds.all.toString(), rootInfo.list.get(position).wind.speed.toString(),
            rootInfo.list.get(position).dt_txt, "http://api.openweathermap.org/img/w/" +
                    rootInfo.list.get(position).weather.get(0).icon
        )

        holder.bind(weatherInfo, onClickItem, position)

    }
}

