package com.android.designsystem.theme.ui

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Multipreview annotation that represents various device sizes. Add this annotation to a composable
 * to render various devices.
 */
@Preview(showBackground = true, locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class DevicePreviews
