package com.android.lobantain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.android.home.navigation.homeNavigationRoute
import com.android.home.navigation.homeScreen
import com.android.home.view.HomeUI
import com.android.lobantain.ui.LbtAppState


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
//        bookmarksScreen(
//            onTopicClick = navController::navigateToTopic,
//            onShowSnackbar = onShowSnackbar,
//        )
//        searchScreen(
//            onBackClick = navController::popBackStack,
//            onInterestsClick = { appState.navigateToTopLevelDestination(INTERESTS) },
//            onTopicClick = navController::navigateToTopic,
//        )
//        interestsGraph(
//            onTopicClick = navController::navigateToTopic,
//            nestedGraphs = {
//                topicScreen(
//                    onBackClick = navController::popBackStack,
//                    onTopicClick = navController::navigateToTopic,
//                )
//            },
//        )
    }
}