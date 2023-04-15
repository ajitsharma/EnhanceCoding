package com.example.enhancecoding.di

import android.content.Context
import androidx.room.Room
import com.example.enhancecoding.db.SingleSearchDB
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(components = [SingletonComponent::class], replaces = [DatabaseModule::class])
@Module
class TestDatabaseModule {

    @Singleton
    @Provides
    fun provideTestDB(@ApplicationContext context: Context): SingleSearchDB {
        return Room.inMemoryDatabaseBuilder(
            context,
            SingleSearchDB::class.java
        ).allowMainThreadQueries().build()
    }
}