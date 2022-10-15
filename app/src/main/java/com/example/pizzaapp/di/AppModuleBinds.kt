package com.example.pizzaapp.di

import com.example.pizzaapp.repositories.menu.DefaultMenuRepository
import com.example.pizzaapp.repositories.menu.MenuRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModuleBinds {
    @Singleton
    @Binds
    abstract fun bindRepository(repo: DefaultMenuRepository): MenuRepository
}