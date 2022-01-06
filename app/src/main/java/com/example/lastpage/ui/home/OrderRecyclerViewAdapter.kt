package com.example.lastpage.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lastpage.databinding.ItemLayoutOrderBinding
import com.example.lastpage.entity.Order

class OrderRecyclerViewAdapter(
private val orders: List<Order>)
: RecyclerView.Adapter<OrderRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemLayoutOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = orders[position]
        holder.idView.text = item.orderId
    }

    override fun getItemCount(): Int = orders.size

    inner class ViewHolder(binding: ItemLayoutOrderBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.orderId

    }


}