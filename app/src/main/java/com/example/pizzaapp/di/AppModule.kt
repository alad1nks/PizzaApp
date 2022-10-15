package com.example.pizzaapp.di

import android.content.Context
import androidx.room.Room
import com.example.pizzaapp.database.ProductsDatabase
import com.example.pizzaapp.network.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    private lateinit var INSTANCE: ProductsDatabase

    @Provides
    @Singleton
    fun provideRetrofit(): ApiService = Retrofit.Builder()
        .baseUrl("https://globalapi.dodopizza.com/api/v2/dodopizza/")
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()))
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideProductsDatabase(context: Context): ProductsDatabase {
        synchronized(ProductsDatabase::class.java) {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    ProductsDatabase::class.java,
                    "products_database").build()
            }
        }
        return INSTANCE
    }

}