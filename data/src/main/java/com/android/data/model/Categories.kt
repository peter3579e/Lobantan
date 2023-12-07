package com.android.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Categories(
    val id: String,
    val title: String,
    val products: List<Product>,
)