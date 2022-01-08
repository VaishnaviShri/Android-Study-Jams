package com.example.lastpage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val orderId: Int = 0,

    @ColumnInfo(name = "cust_name")
    var customerName: String = "",

    @ColumnInfo(name = "address")
    var address: String = "",

    @ColumnInfo(name = "product_list")
    var productList: MutableList<Product> = mutableListOf(),

    @ColumnInfo(name = "total")
    var total: Float = 0f,

    @ColumnInfo(name = "status")
    var orderStatus: Int = 0
)

