package com.android.lobantain.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.android.designsystem.theme.icon.LbtIcons

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: String,
    val titleTextId: String,
) {
    HOME(
        selectedIcon = LbtIcons.Home,
        unselectedIcon = LbtIcons.HomeBoarder,
        iconTextId = "Home",
        titleTextId = "Home",
    ),
    MESSAGE(
        selectedIcon = LbtIcons.Message,
        unselectedIcon = LbtIcons.MessageBoarder,
        iconTextId = "Message",
        titleTextId = "Message",
    ),
    PROFILE(
        selectedIcon = LbtIcons.Profile,
        unselectedIcon = LbtIcons.ProfileBoarder,
        iconTextId = "Profile",
        titleTextId = "Profile",
    ),
}