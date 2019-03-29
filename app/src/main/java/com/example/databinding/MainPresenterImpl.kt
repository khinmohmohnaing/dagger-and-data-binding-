package com.example.databinding

import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    val view: MainView
): MainPresenter {


    override fun loadInitData() {
    }

}