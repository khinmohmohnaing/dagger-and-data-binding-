package com.example.databinding

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.databinding.databinding.WeatherItemBinding

//abstract class BaseVH(itemView: WeatherItemBinding) : RecyclerView.ViewHolder(itemView.root) {
abstract class BaseVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(itemlist: InfoList, onclicklistener: BaseVH.onclick, position: Int)

    interface onclick {
        fun onItemClick(position: Int)
    }
}