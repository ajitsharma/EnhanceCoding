package com.example.enhancecoding.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "singleSearch")
data class SingleSearchResponseModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val premiered: String,
    val image: Image
)