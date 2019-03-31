package com.example.databinding

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.weather_item.view.*
import android.databinding.ViewDataBinding
import com.example.databinding.databinding.WeatherItemBinding

//class WeatherViewHolder(itemView: WeatherItemBinding): BaseVH(itemView) {
class WeatherViewHolder(itemView: View): BaseVH(itemView) {
    //https://www.androidhive.info/android-databinding-in-recyclerview-profile-screen/
   // var binding=itemView
    override fun bind(itemlist: InfoList, onclicklistener: onclick, position: Int) {
       /* binding.setVariable(BR.info,itemlist)
        binding.executePendingBindings()*/
        itemView.weathername.text=itemlist.weather.get(0).description
       itemView.cloudss.text=itemlist.clouds.all.toString()
       itemView.winds.text=itemlist.wind.speed.toString()
       itemView.dates.text=itemlist.dt_txt.toString()
       Glide.with(itemView.context)
           .load("http://api.openweathermap.org/img/w/" +
                   itemlist.weather.get(0).icon).into(itemView.img)
       itemView.setOnClickListener{itemView->onclicklistener.onItemClick(position)}
       itemView.detailbtn.setOnClickListener{itemView->onclicklistener.onItemClick(position)}
       }
    }


