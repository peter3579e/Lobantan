package com.android.data.repository

import com.android.data.model.Categories

interface HomeRepository {

    suspend fun getHomeCategoriesList(): List<Categories>

}