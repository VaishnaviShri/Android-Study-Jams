package com.example.lastpage.ui.addOrder

import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.databinding.InverseBindingMethods
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lastpage.database.MainDao
import com.example.lastpage.database.Order
import com.example.lastpage.database.Product
import kotlinx.coroutines.*

@InverseBindingMethods
class AddOrderViewModel(private val dataSource: MainDao) : ViewModel() {

    private val _name = MutableLiveData("")
    private val _address = MutableLiveData("")
    private val _productList = MutableLiveData<List<Product>>(listOf())
    private val _selection = MutableLiveData(0)
    private val _selectedList = MutableLiveData<MutableList<Product>>(mutableListOf())
    private val _selectedText = MutableLiveData("Selected products: ")

    val name: LiveData<String>
        get() = _name

    val address: LiveData<String>
        get() = _address

    val productList: LiveData<List<Product>>
        get() = _productList

    val selectedList: LiveData<MutableList<Product>>
        get() = _selectedList

    val selection: LiveData<Int>
        get() = _selection

    val selectedText: LiveData<String>
        get() = _selectedText

    private val uiScope = CoroutineScope(Dispatchers.Main + Job())

    init {
        getProductList()
    }

    private fun getProductList() {

        uiScope.launch {
            withContext(Dispatchers.IO) {
                _productList.postValue(dataSource.getAllProducts())
            }
        }

    }

    fun select() {
        if(_productList.value!!.isNotEmpty()) {
            _selectedList.value!!.add(_productList.value!![_selection.value!!])
            _selectedText.value =
                _selectedText.value + _productList.value!![_selection.value!!].toString() + ", "
        }
        Log.v("viewmodel", _selectedText.value!!)
    }

    val listener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            _selection.value = position
        }
    }

    fun order() {
        var total = 0f

        for (i in _selectedList.value!!) {
            total += i.price
        }

        val order = Order(customerName = _name.value!!, address = _address.value!!, productList = _selectedList.value!!, total = total, orderStatus = 0)

        uiScope.launch {
            withContext(Dispatchers.IO) {
                dataSource.insertOrder(order)
            }
        }


    }



}