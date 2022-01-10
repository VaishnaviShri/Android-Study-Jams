package com.example.lastpage.ui.inventory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lastpage.database.MainDao
import com.example.lastpage.database.Order
import com.example.lastpage.database.Product
import kotlinx.coroutines.*

class InventoryViewModel(private val dataSource: MainDao) : ViewModel() {

    private val uiScope = CoroutineScope(Dispatchers.Main + Job())

    private val _productList = MutableLiveData<List<Product>>(listOf())

    val productList: LiveData<List<Product>>
        get() = _productList

    init {
        getProducts()
    }

    private fun getProducts() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                _productList.postValue(dataSource.getAllProducts())
            }
        }
    }
}
