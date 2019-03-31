package com.example.databinding

import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import android.databinding.BindingAdapter
import android.widget.ImageView


data class DetailInfo(var description:String?,var clouds: String?,var wind:String?,var date : String?,var icon:String?){
   /* @BindingAdapter("icon")
    fun loadImage(view: ImageView, imageUrl: String) {
        Glide.with(view.getContext())
            .load(imageUrl).apply(RequestOptions().circleCrop())
            .into(view)
    }*/
}