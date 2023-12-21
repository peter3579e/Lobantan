package com.android.home.component.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.data.model.Product
import com.android.designsystem.component.DynamicAsyncImage
import com.android.designsystem.theme.LbtTheme
import com.android.designsystem.theme.ui.DevicePreviews

@Composable
fun ProductUI(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.padding(horizontal = 10.dp)
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            DynamicAsyncImage(
                imageUrl = product.image,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 12.dp),
            )
            Text(text = product.price)
        }
    }
}

@Composable
@DevicePreviews
fun previewProduct() {
    LbtTheme {
        ProductUI(
            Product(
                id = "101",
                image = "https://picsum.photos/300/200?random=1",
                title = "Smartphone",
                price = "£300",
                years = 2
            )
        )
    }
}
