package com.example.lastpage.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lastpage.database.MainDao
import com.example.lastpage.database.Order
import kotlinx.coroutines.*

class HomeViewModel(private val dataSource: MainDao) : ViewModel() {

    private val uiScope = CoroutineScope(Dispatchers.Main + Job())

    private val _orderList = MutableLiveData<List<Order>>(listOf())

    val orderList: LiveData<List<Order>>
        get() = _orderList

    init {
        getOrders()
    }

    private fun getOrders() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                _orderList.postValue(dataSource.getAllOrders())
            }
        }
    }
}