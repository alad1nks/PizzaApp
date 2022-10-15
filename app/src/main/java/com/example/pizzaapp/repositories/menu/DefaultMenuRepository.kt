package com.example.pizzaapp.repositories.menu

import com.example.pizzaapp.R
import com.example.pizzaapp.database.ProductsDatabase
import com.example.pizzaapp.database.model.asDomain
import com.example.pizzaapp.domain.MenuRadioButton
import com.example.pizzaapp.domain.Product
import com.example.pizzaapp.network.ApiService
import com.example.pizzaapp.network.domain.asDatabase
import com.example.pizzaapp.network.domain.asDomain
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultMenuRepository @Inject constructor(
    private val database: ProductsDatabase,
    private val api: ApiService
): MenuRepository {

    private val db = database.productsDao()

    override suspend fun getRadioButtons(): List<MenuRadioButton> {
        return listOf(MenuRadioButton("Пицца", true), MenuRadioButton("Комбо", false), MenuRadioButton("Десерты", false), MenuRadioButton("Напитки", false), MenuRadioButton("Закуски", false), MenuRadioButton("Другие товары", false))
    }

    override suspend fun getProducts(): List<Product> {
        return db.getProducts().map { it.asDomain() }
    }

    override suspend fun getProductsApi(): List<Product> {
        val products = api.getPizza()
        db.insertProducts(products.map { it.asDatabase() })
        return products.map { it.asDomain() }
    }

    override suspend fun getAdItems(): List<Int> {
        return listOf(R.drawable.ad_img, R.drawable.ad_img, R.drawable.ad_img)
    }

}