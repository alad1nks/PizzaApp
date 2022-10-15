package com.example.pizzaapp.repositories.menu

import com.example.pizzaapp.domain.MenuRadioButton
import com.example.pizzaapp.domain.Product

interface MenuRepository {
    suspend fun getRadioButtons(): List<MenuRadioButton>
    suspend fun getProducts(): List<Product>
    suspend fun getProductsApi(): List<Product>
    suspend fun getAdItems(): List<Int>
}