package com.example.pizzaapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pizzaapp.database.model.DatabaseProduct

@Database(entities = [DatabaseProduct::class], version = 1, exportSchema = false)
abstract class ProductsDatabase: RoomDatabase() {
    abstract fun productsDao(): ProductsDao
}