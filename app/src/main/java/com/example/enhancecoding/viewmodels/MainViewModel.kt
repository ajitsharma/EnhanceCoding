package com.example.enhancecoding.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.enhancecoding.model.SingleSearchResponseModel
import com.example.enhancecoding.repositories.SingleSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val singleSearchRepository: SingleSearchRepository) :
    ViewModel() {

    val singleSearchLiveData: LiveData<SingleSearchResponseModel>
        get() = singleSearchRepository.singleSearchLiveData

    fun getSingleSearchData(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            singleSearchRepository.getSingleSearchData(query)
        }
    }
}