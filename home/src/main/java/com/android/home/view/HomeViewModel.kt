package com.android.home.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            Log.d("peter", homeRepository.getHomeCategoriesList().toString())
            println(homeRepository.getHomeCategoriesList())
        }
    }
}