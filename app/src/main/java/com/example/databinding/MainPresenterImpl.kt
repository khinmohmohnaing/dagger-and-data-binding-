package com.example.databinding

import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    val view: MainView
): MainPresenter {
    @Inject
    lateinit var mainInteract: MainInteract
    override fun loadInitData() {
    }

}