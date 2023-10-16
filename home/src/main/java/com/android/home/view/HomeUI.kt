package com.android.home.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.designsystem.theme.LbtTheme
import com.android.home.model.HeaderUiModel

@Composable
fun HomeUI() {
    Column {
        HeaderItem(headerUiModel = HeaderUiModel("Home"))
    }
}


@Composable
@Preview(showBackground = true, locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO)
fun previewHome() {
    LbtTheme {
        HomeUI()
    }
}