package com.android.data.repository

import com.android.data.model.Categories

interface LbtNetworkDataSource {

    suspend fun getHomeCategoriesList(): List<Categories>

}