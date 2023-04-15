package com.example.enhancecoding.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.enhancecoding.api.TVMazeAPI
import com.example.enhancecoding.db.SingleSearchDB
import com.example.enhancecoding.model.SingleSearchResponseModel
import javax.inject.Inject

class SingleSearchRepository @Inject constructor(
    private val tvMazeAPIInterface: TVMazeAPI,
    private val singleSearchDB: SingleSearchDB
) {

    private var _singleSearchLiveData: MutableLiveData<SingleSearchResponseModel> =
        MutableLiveData()
    val singleSearchLiveData: LiveData<SingleSearchResponseModel>
        get() = _singleSearchLiveData

    suspend fun getSingleSearchData(queryString: String) {
        val dbSearchData = getSingleSearchFroDB(queryString)
        if (dbSearchData != null) {
            _singleSearchLiveData.postValue(dbSearchData)
        } else {
            val searchData = tvMazeAPIInterface.getSingleSearchData(queryString).body()
            searchData?.let {
                _singleSearchLiveData.postValue(it)
                insertSingleSearch(it)
            }
        }
    }


    suspend fun insertSingleSearch(singleSearchResponseModel: SingleSearchResponseModel) {
        singleSearchDB.singleSearchDao().insertSingleSearch(singleSearchResponseModel)
    }

    suspend fun getSingleSearchFroDB(queryString: String): SingleSearchResponseModel {
        return singleSearchDB.singleSearchDao().getSingleSearchData(queryString)
    }

}