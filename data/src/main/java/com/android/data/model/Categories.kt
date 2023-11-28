package com.android.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Categories(
    val id: String? = null,
    val title: String? = null,
    val products: List<Product>? = null,
)