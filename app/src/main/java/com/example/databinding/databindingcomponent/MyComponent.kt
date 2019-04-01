package com.example.databinding.databindingcomponent

import android.databinding.DataBindingComponent
import com.example.databinding.databindingcomponent.BaseImageBinding
import com.example.databinding.databindingcomponent.BaseImageBindingInterface

class MyComponent :DataBindingComponent {
    override fun getBaseImageBindingInterface(): BaseImageBindingInterface {
        return BaseImageBinding()
    }
}