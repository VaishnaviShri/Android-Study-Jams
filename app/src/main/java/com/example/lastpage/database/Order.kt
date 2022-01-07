package com.example.lastpage.database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "orders")
data class Order(

    @ColumnInfo(name = "id")
    val orderId: String,

    @ColumnInfo(name = "cust_name")
    var customerName: String = "",

    @ColumnInfo(name = "address")
    var address: String = "",

    @ColumnInfo(name = "product_list")
    var productList: MutableList<Product> = mutableListOf(),

    @ColumnInfo(name = "total")
    var total: Float = 0f,

    @ColumnInfo(name = "status")
    var orderStatus: Int = 1
)

