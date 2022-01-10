package com.example.lastpage.ui.addProduct

import androidx.databinding.InverseBindingMethods
import androidx.lifecycle.ViewModel
import com.example.lastpage.database.MainDao
import com.example.lastpage.database.Product
import kotlinx.coroutines.*

@InverseBindingMethods
class AddProductViewModel(private val dataSource: MainDao) : ViewModel() {

    private val uiScope = CoroutineScope(Dispatchers.Main + Job())
    fun addProduct(name: String, price: Double) {
        val product = Product(0, name, price)
        uiScope.launch {
            withContext(Dispatchers.IO) {
                dataSource.insertProduct(product)
            }
        }
    }
}