package com.example.pizzaapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pizzaapp.database.model.DatabaseProduct

@Dao
interface ProductsDao {
    @Query("SELECT * FROM databaseproduct")
    fun getProducts(): List<DatabaseProduct>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(product: List<DatabaseProduct>)
}