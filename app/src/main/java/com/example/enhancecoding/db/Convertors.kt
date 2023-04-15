package com.example.enhancecoding.db

import androidx.room.TypeConverter
import com.example.enhancecoding.model.Image
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Convertors {

    @TypeConverter
    fun fromImage(imageData: Image): String {
        return imageData.toString()
    }
    @TypeConverter
    fun toImage(imageData: String): Image {
        val type: Type = object : TypeToken<Image>() {}.type
        return Gson().fromJson(imageData, type)
    }
}