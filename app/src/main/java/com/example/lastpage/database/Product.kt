package com.example.lastpage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "productID")
    val productID: Int =0,

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "price")
    val price: Double = 0.0


) {
    override fun toString(): String {
        return name
    }
}
