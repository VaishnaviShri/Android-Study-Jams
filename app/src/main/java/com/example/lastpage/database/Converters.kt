package com.example.lastpage.database

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType
import java.lang.reflect.ParameterizedType

class Converters {

    private val moshi = Moshi.Builder().build()

    private val list : ParameterizedType = newParameterizedType(MutableList::class.java, Product::class.java)
    private val listStringJsonAdapter: JsonAdapter<List<Product>> = moshi.adapter(list)

    @TypeConverter
    fun listStringToJsonStr(listMyModel: List<Product>?): String? {
        return listStringJsonAdapter.toJson(listMyModel)
    }

    @TypeConverter
    fun jsonStrToListString(jsonStr: String?): List<Product>? {
        return jsonStr?.let { listStringJsonAdapter.fromJson(jsonStr) }
    }

}