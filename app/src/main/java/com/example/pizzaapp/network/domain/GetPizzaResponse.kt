package com.example.pizzaapp.network.domain

import android.os.Parcelable
import com.example.pizzaapp.R
import com.example.pizzaapp.database.model.DatabaseProduct
import com.example.pizzaapp.domain.Product
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class GetPizzaResponse(
    @Json(name = "id")
    val id: String,

    @Json(name = "name")
    val name: String
) : Parcelable

fun GetPizzaResponse.asDomain() : Product {
    return Product(
        name = name,
        ingredients = "Картошка",
        image = R.drawable.pizza_1
    )
}

fun GetPizzaResponse.asDatabase() : DatabaseProduct {
    return DatabaseProduct(
        name = name,
        ingredients = "Картошка",
        image = R.drawable.pizza_1
    )
}
