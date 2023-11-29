package com.android.lobantan.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.android.designsystem.theme.icon.LbtIcons
import com.android.lobantan.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    HOME(
        selectedIcon = LbtIcons.Home,
        unselectedIcon = LbtIcons.HomeBoarder,
        iconTextId = R.string.home,
        titleTextId = R.string.home,
    ),
    MESSAGE(
        selectedIcon = LbtIcons.Message,
        unselectedIcon = LbtIcons.MessageBoarder,
        iconTextId = R.string.message,
        titleTextId = R.string.message,
    ),
    PROFILE(
        selectedIcon = LbtIcons.Profile,
        unselectedIcon = LbtIcons.ProfileBoarder,
        iconTextId = R.string.profile,
        titleTextId = R.string.profile,
    ),
}