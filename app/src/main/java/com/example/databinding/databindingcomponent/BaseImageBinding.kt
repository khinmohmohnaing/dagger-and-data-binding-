package com.example.databinding.databindingcomponent

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BaseImageBinding : BaseImageBindingInterface {
    override fun loadImage(view: ImageView, url: String) {
        Glide.with(view.getContext())
            .load(url).apply(RequestOptions().circleCrop())
            .into(view)
    }

}