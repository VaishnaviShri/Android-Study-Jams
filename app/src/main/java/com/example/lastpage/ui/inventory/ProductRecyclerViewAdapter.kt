package com.example.lastpage.ui.inventory

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lastpage.database.Order
import com.example.lastpage.database.Product
import com.example.lastpage.databinding.ItemLayoutOrderBinding
import com.example.lastpage.databinding.ItemLayoutProductBinding

class ProductRecyclerViewAdapter(
    private val products: List<Product>)
    : RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemLayoutProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = products[position]
        holder.productName.text = item.name
        holder.price.text = item.price.toString()
    }

    override fun getItemCount(): Int = products.size

    inner class ViewHolder(binding: ItemLayoutProductBinding) : RecyclerView.ViewHolder(binding.root) {
        val productName: TextView = binding.productName
        val price: TextView = binding.productPrice
    }


}