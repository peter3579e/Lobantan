package com.android.profile.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.designsystem.component.HeaderItem
import com.android.designsystem.model.HeaderUiModel
import com.android.designsystem.theme.LbtTheme
import com.android.designsystem.theme.ui.DevicePreviews

@Composable
fun ProfileUI() {
    Column {
        HeaderItem(headerUiModel = HeaderUiModel("Profile"))
    }
}


@Composable
@DevicePreviews
fun previewHome() {
    LbtTheme {
        ProfileUI()
    }
}