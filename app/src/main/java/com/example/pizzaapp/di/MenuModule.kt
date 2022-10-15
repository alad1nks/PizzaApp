package com.example.pizzaapp.di

import androidx.lifecycle.ViewModel
import com.example.pizzaapp.ui.menu.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MenuModule {
    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindViewModel(viewmodel: MenuViewModel): ViewModel
}