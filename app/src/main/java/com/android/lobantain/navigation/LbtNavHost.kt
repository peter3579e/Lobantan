package com.android.lobantain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.android.home.navigation.homeNavigationRoute
import com.android.home.navigation.homeScreen
import com.android.lobantain.ui.LbtAppState
import com.android.message.navigation.messageScreen
import com.android.profile.navigation.profileScreen


/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@Composable
fun LbtNavHost(
    appState: LbtAppState,
//    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
    startDestination: String = homeNavigationRoute,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen()
        messageScreen()
//        searchScreen(
//            onBackClick = navController::popBackStack,
//            onInterestsClick = { appState.navigateToTopLevelDestination(INTERESTS) },
//            onTopicClick = navController::navigateToTopic,
//        )
        profileScreen()
    }
}