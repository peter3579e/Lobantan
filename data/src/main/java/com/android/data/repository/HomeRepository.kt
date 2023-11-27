package com.android.data.repository

import com.android.data.model.Categories

interface HomeRepository {

    fun getHomeCategoriesList(): List<Categories>
}