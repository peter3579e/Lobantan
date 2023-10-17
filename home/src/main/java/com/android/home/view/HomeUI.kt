package com.android.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.android.designsystem.component.widget.HeaderItem
import com.android.designsystem.theme.LbtTheme
import com.android.designsystem.model.HeaderUiModel
import com.android.designsystem.theme.ui.DevicePreviews

@Composable
fun HomeUI() {
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