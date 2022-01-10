package com.example.lastpage.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lastpage.database.Order
import com.example.lastpage.databinding.ItemLayoutOrderBinding

class OrderRecyclerViewAdapter(
    private val orders: List<Order>,
    private val onItemClick: (Order) -> Unit
) : RecyclerView.Adapter<OrderRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLayoutOrderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = orders[position]
        holder.idView.text = "Order " + item.orderId.toString()
        holder.customerName.text = item.customerName
        holder.orderAddress.text = item.address
        holder.price.text = "Price: " + item.total.toString()

        holder.doneButton.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount(): Int = orders.size

    inner class ViewHolder(binding: ItemLayoutOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.orderId
        val price: TextView = binding.price
        val customerName: TextView = binding.customerName
        val orderAddress: TextView = binding.orderAddress

        val doneButton: ImageView = binding.doneImage
    }
}