package com.example.enhancecoding.di

import com.example.enhancecoding.api.TVMazeAPI
import com.example.enhancecoding.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesSingleSearchAPI(retrofit: Retrofit): TVMazeAPI {
        return retrofit.create(TVMazeAPI::class.java)
    }

}