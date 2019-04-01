package com.example.databinding.databindingcomponent

import android.graphics.drawable.Drawable
import android.databinding.BindingAdapter
import android.widget.ImageView


interface BaseImageBindingInterface {
    @BindingAdapter("icon")
    fun loadImage(view: ImageView, url: String)
}