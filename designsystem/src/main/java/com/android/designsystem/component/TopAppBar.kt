package com.android.designsystem.component

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.designsystem.R
import com.android.designsystem.theme.icon.LbtIcons
import com.android.designsystem.theme.ui.DevicePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LbtTopAppBar (
    @SuppressLint("SupportAnnotationUsage") @StringRes titleRes: Int,
    navigationIcon: ImageVector,
    navigationIconContentDescription: String?,
    actionIcon: ImageVector,
    actionIconContentDescription: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
    navigationIcon = {
        IconButton(onClick = onNavigationClick) {
            Icon(
                imageVector = navigationIcon,
                contentDescription = navigationIconContentDescription,
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
    },
//    actions = {
//        IconButton(onClick = onActionClick) {
//            Icon(
//                imageVector = actionIcon,
//                contentDescription = actionIconContentDescription,
//                tint = MaterialTheme.colorScheme.onSurface,
//            )
//        }
//    },
    colors = colors,
    modifier = modifier.testTag("LbtTopAppBar"),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@DevicePreviews
@Composable
private fun NiaTopAppBarPreview() {
    LbtTopAppBar(
        titleRes = R.string.untitled,
        navigationIcon = LbtIcons.Search,
        navigationIconContentDescription = "Navigation icon",
        actionIcon = LbtIcons.MoreVert,
        actionIconContentDescription = "Action icon",
    )
}