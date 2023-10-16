package com.android.message.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable


const val messageRoute = "bookmarks_route"

fun NavController.navigateToMessage(navOptions: NavOptions? = null) {
    this.navigate(messageRoute, navOptions)
}

fun NavGraphBuilder.messageScreen(
    onTopicClick: (String) -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable(route = messageRoute) {
//        BookmarksRoute(onTopicClick, onShowSnackbar)
    }
}