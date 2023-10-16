package com.android.profile.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.designsystem.component.HeaderItem
import com.android.designsystem.model.HeaderUiModel
import com.android.designsystem.theme.LbtTheme

@Composable
fun ProfileUI() {
    Column {
        HeaderItem(headerUiModel = HeaderUiModel("Profile"))
    }
}


@Composable
@Preview(showBackground = true, locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO)
fun previewHome() {
    LbtTheme {
        ProfileUI()
    }
}