package com.example.pizzaapp.di

import com.example.pizzaapp.ui.menu.MenuFragment
import dagger.Subcomponent

@Subcomponent(modules = [MenuModule::class])
interface MenuComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MenuComponent
    }
    fun inject(fragment: MenuFragment)
}