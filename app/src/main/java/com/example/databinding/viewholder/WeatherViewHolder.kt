package com.example.databinding.viewholder

import com.example.databinding.base.BaseVH
import com.example.databinding.ViewHolderEvenListener
import com.example.databinding.model.WeatherInfo
import com.example.databinding.databinding.WeatherItemBinding

class WeatherViewHolder(itemView: WeatherItemBinding) : BaseVH(itemView) {
    var binding = itemView
    override fun bind(itemlist: WeatherInfo, onclicklistener: ViewHolderEvenListener, position: Int) {
        binding.info = itemlist
        binding.viewholder = onclicklistener
    }
}


