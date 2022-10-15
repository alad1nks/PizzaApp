package com.example.pizzaapp.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pizzaapp.domain.Product

@Entity(tableName = "databaseproduct")
data class DatabaseProduct(
    @PrimaryKey
    val name: String,
    val ingredients: String,
    val image: Int
)

fun DatabaseProduct.asDomain() : Product {
    return Product(
        name = name,
        ingredients = ingredients,
        image = image
    )
}
