package com.android.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation

private const val interestsGraphRoutePattern = "interests_graph"
const val profileRoute = "interests_route"

fun NavController.navigateToProfile(navOptions: NavOptions? = null) {
    this.navigate(interestsGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.interestsGraph(
    onTopicClick: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = interestsGraphRoutePattern,
        startDestination = profileRoute,
    ) {
        composable(route = profileRoute) {
//            InterestsRoute(onTopicClick)
        }
        nestedGraphs()
    }
}