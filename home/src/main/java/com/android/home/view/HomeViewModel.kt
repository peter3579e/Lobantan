package com.android.home.view

import androidx.lifecycle.ViewModel
import com.android.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {

//    fun printJson() {
//        println(homeRepository.getHomeCategoriesList())
//    }
}