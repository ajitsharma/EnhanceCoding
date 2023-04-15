package com.example.enhancecoding.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.enhancecoding.model.SingleSearchResponseModel

@Dao
interface SingleSearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSingleSearch(model: SingleSearchResponseModel)

    @Query("SELECT * FROM singleSearch WHERE name = :queryString")
    suspend fun getSingleSearchData(queryString: String): SingleSearchResponseModel

}