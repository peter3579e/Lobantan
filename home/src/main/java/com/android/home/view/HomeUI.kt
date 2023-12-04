package com.android.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.designsystem.component.widget.HeaderItem
import com.android.designsystem.model.HeaderUiModel
import com.android.designsystem.theme.LbtTheme
import com.android.designsystem.theme.ui.DevicePreviews

@Composable
internal fun HomeUI(
    viewModel: HomeViewModel = hiltViewModel()
) {
    viewModel
    Column {
        HeaderItem(headerUiModel = HeaderUiModel("Home"))
    }
}


@Composable
@DevicePreviews
fun previewHome() {
    LbtTheme {
        HomeUI()
    }
}