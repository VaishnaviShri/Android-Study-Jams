package com.example.lastpage.ui.addProduct

import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lastpage.database.MainDao
import com.example.lastpage.database.Order
import com.example.lastpage.database.Product
import kotlinx.coroutines.*

@InverseBindingMethods
class AddProductViewModel (private val dataSource: MainDao) : ViewModel(){
    // TODO: Implement the ViewModel
    private val _name = MutableLiveData("")
    private val _price = MutableLiveData(0.0)

    private val uiScope = CoroutineScope(Dispatchers.Main + Job())
    fun addProduct() {

        val product = Product(0,_name.value!!,_price.value!!)
        uiScope.launch {
            withContext(Dispatchers.IO) {
                dataSource.insertProduct(product)
            }
        }


    }
}