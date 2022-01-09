package com.example.lastpage.database

import androidx.room.*

@Dao
interface MainDao {

    @Insert
    fun insertOrder(order: Order)

    @Insert
    fun insertProduct(product: Product)

    @Update
    fun updateOrder(order: Order)

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun deleteOrder(order: Order)

    @Delete
    fun deleteProduct(product: Product)

    @Query("SELECT * FROM orders WHERE id = :id")
    fun getOrder(id: String): Order?

    @Query("SELECT * FROM orders")
    fun getAllOrders(): List<Order>

    @Query("SELECT * FROM products")
    fun getAllProducts(): List<Product>

    @Query("UPDATE orders SET status = 1 WHERE id = :id")
    fun updateOrderStatus(id: String)
}