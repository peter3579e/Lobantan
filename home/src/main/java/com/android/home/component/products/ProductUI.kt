package com.android.home.component.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.designsystem.component.DynamicAsyncImage
import com.android.designsystem.theme.LbtTheme
import com.android.designsystem.theme.ui.DevicePreviews

@Composable
fun ProductUI(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(horizontal = 12.dp)
    ) {
        DynamicAsyncImage(
            imageUrl = imageUrl,
            contentDescription = null,
            modifier = Modifier
        )
        Row {
            Text(text = "£25.00")
        }
    }
}

@Composable
@DevicePreviews
fun previewProduct() {
    LbtTheme {
        ProductUI(imageUrl = "https://picsum.photos/300/200?random=2")
    }
}
