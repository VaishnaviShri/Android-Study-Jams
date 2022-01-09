package com.example.lastpage

import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import com.example.lastpage.database.Product

@BindingAdapter("onItemClicked")
fun Spinner.click(listener: AdapterView.OnItemSelectedListener) {
    onItemSelectedListener = listener
}