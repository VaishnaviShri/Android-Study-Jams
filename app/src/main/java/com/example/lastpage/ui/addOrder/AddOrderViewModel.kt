package com.example.lastpage.ui.addOrder

import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lastpage.database.Product

@InverseBindingMethods
class AddOrderViewModel : ViewModel() {

    private val _id = MutableLiveData("")
    private val _name = MutableLiveData("")
    private val _address = MutableLiveData("")
    private val _productList = MutableLiveData(listOf(Product("juice", 30f), Product("ur mom", 25.5f)))
    private val _selection = MutableLiveData(0)
    private val _selectedList = MutableLiveData<MutableList<Product>>(mutableListOf())
    private val _selectedText = MutableLiveData("Selected products: ")

    val id: LiveData<String>
        get() = _id

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

    fun select() {
        _selection.value?.let { f -> _productList.value?.get(f)?.let { _selectedList.value?.add(it) } }
        _selectedText.value = _selectedText.value + _selection.value?.let {
            _productList.value?.get(
                it
            ).toString() + ", "
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


}