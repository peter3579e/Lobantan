package com.android.home.component.products

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.designsystem.component.DynamicAsyncImage

@Composable
internal fun ProductUI(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    Column {
        DynamicAsyncImage(imageUrl = imageUrl, contentDescription = null)
    }
}