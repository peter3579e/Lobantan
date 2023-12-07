package com.android.data.repository

import com.android.data.model.Categories
import com.android.data.model.Product
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    /**
     * Gets the available categories as a stream
     */
    fun getCategories(): Flow<List<Categories>>

    /**
     * Gets the available products as a stream
     */
    fun getProducts(id: String): Flow<List<Product>>
}