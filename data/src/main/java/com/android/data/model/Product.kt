package com.android.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String,
    val image: String,
    val title: String,
    val price: String,
    var years: Int? = null,
    var minSize: Int = 0,
    var maxSize: Int = 0,
) {
    val sizeRange get() = getRange()
    val yearsString get() = "$years year"

    private fun getRange(): String {
        return if (minSize == 0 || maxSize == 0) {
            "${maxOf(minSize, maxSize)} cm"
        } else {
            "$minSize - $maxSize cm"
        }
    }
}
