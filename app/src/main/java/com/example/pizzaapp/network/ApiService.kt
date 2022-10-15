package com.example.pizzaapp.network

import com.example.pizzaapp.network.domain.GetPizzaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("countries")
    suspend fun getPizza() : List<GetPizzaResponse>

}