package com.example.lastpage.database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "products")
data class Product(

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "price")
    val price: Float
)
