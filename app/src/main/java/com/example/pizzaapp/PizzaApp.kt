package com.example.pizzaapp

import android.app.Application
import com.example.pizzaapp.di.AppComponent
import com.example.pizzaapp.di.DaggerAppComponent

open class PizzaApp: Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }

}