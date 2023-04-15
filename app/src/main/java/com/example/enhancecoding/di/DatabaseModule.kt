package com.example.enhancecoding.di

import android.content.Context
import androidx.room.Room
import com.example.enhancecoding.db.SingleSearchDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideSingleSearchDB(@ApplicationContext context: Context): SingleSearchDB{
        return Room.databaseBuilder(context, SingleSearchDB::class.java, "singlesearchdatabase").build()
    }
}