package com.example.enhancecoding.api

import com.example.enhancecoding.model.SingleSearchResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TVMazeAPI {

    @GET("/singlesearch/shows")
    suspend fun getSingleSearchData(@Query("q") q: String): Response<SingleSearchResponseModel>
}