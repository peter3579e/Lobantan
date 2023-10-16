package com.android.message.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.message.view.MessageUI


const val messageRoute = "message_route"

fun NavController.navigateToMessage(navOptions: NavOptions? = null) {
    this.navigate(messageRoute, navOptions)
}

fun NavGraphBuilder.messageScreen(
) {
    composable(route = messageRoute) {
        MessageUI()
    }
}