package com.example.pizzaapp.di

import android.content.Context
import com.example.pizzaapp.repositories.menu.MenuRepository
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AppModuleBinds::class,
        SubcomponentsModule::class,
        ViewModelBuilderModule::class

    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun menuComponent(): MenuComponent.Factory
    val menuRepository: MenuRepository

}

@Module(
    subcomponents = [
        MenuComponent::class
    ]
)
object SubcomponentsModule