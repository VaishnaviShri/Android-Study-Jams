package com.example.lastpage.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lastpage.databinding.ItemLayoutOrderBinding
import com.example.lastpage.database.Order

class OrderRecyclerViewAdapter(
private val orders: List<Order>)
: RecyclerView.Adapter<OrderRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemLayoutOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = orders[position]
        holder.idView.text = "Order " + item.orderId.toString()
        holder.customerName.text = item.customerName
        holder.orderAddress.text = item.address
        holder.price.text = "Price: " + item.total.toString()
        holder.status.text = "Status: " + if (item.orderStatus == 0) "Pending" else "Complete"
        holder.complete.visibility = if (item.orderStatus == 1) View.GONE else View.VISIBLE
    }

    override fun getItemCount(): Int = orders.size

    inner class ViewHolder(binding: ItemLayoutOrderBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.orderId
        val price: TextView = binding.price
        val customerName : TextView = binding.customerName
        val orderAddress : TextView = binding.orderAddress
        val status: TextView = binding.status
        val complete: Button = binding.complete
    }


}