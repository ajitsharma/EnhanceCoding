package com.example.enhancecoding.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.enhancecoding.model.SingleSearchResponseModel

@Database(entities = [SingleSearchResponseModel::class], version = 1)
@TypeConverters(value = [Convertors::class])
abstract class SingleSearchDB : RoomDatabase() {

    abstract fun singleSearchDao(): SingleSearchDao
}