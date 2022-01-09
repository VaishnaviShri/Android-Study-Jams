package com.example.lastpage.ui.addOrder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lastpage.database.MainDao

class AddOrderViewModelFactory(
    private val dataSource: MainDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddOrderViewModel::class.java)) {
            return AddOrderViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}