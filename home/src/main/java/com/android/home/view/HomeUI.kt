package com.android.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.designsystem.component.widget.HeaderItem
import com.android.designsystem.model.HeaderUiModel
import com.android.designsystem.theme.LbtTheme
import com.android.designsystem.theme.ui.DevicePreviews
import com.android.home.component.products.ProductUI

@Composable
internal fun HomeUI(
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val fakeHomeRepository = viewModel.getFakeHomeRepository()
    Column(
        modifier
    ) {
        HomeItem(name = "home", imageUrl = "https://picsum.photos/300/200?random=2")
    }
}

@Composable
internal fun HomeItem(
    name: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
    ) {
        HeaderItem(headerUiModel = HeaderUiModel("Home"))
        ListItem(headlineContent = {
            Text(text = name)
        },
            trailingContent = {
                ProductUI(imageUrl = imageUrl)
            }
        )
    }
}


@Composable
@DevicePreviews
fun previewHome() {
    LbtTheme {
        HomeItem("peter", "https://picsum.photos/300/200?random=2")
    }
}