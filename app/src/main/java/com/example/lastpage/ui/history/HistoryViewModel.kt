package com.example.lastpage.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lastpage.database.MainDao
import com.example.lastpage.database.Order
import kotlinx.coroutines.*

class HistoryViewModel(private val dataSource: MainDao) : ViewModel() {

    private val uiScope = CoroutineScope(Dispatchers.Main + Job())

    init {
        getHistory()
    }

    private val _orderList = MutableLiveData<List<Order>>(listOf())
    val orderList: LiveData<List<Order>>
        get() = _orderList

    private fun getHistory() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                _orderList.postValue(dataSource.getAllOrders().filter { it.orderStatus == 1 })
            }
        }
    }
}