package com.android.lobantain.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.android.designsystem.component.LbtNavigationBar
import com.android.designsystem.component.LbtNavigationBarItem
import com.android.designsystem.theme.LbtTheme
import com.android.lobantain.navigation.LbtNavHost
import com.android.lobantain.navigation.TopLevelDestination

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalComposeUiApi::class, ExperimentalLayoutApi::class)
@Composable
fun LbtApp(
    windowSizeClass: WindowSizeClass,
    appState: LbtAppState = rememberLbtAppState(
        windowSizeClass = windowSizeClass
    ),
) {

    val snackbarHostState = remember { SnackbarHostState() }


    Scaffold(
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                LbtBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                    modifier = Modifier.testTag("NiaBottomBar"),
                )
            }
        }
    ) { padding ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {
            if (appState.shouldShowNavRail) {
            }

            Column(Modifier.fillMaxSize()) {
                // Show the top app bar on top level destinations.
                val destination = appState.currentTopLevelDestination
                if (destination != null) {
//                    NiaTopAppBar(
//                        titleRes = destination.titleTextId,
//                        navigationIcon = NiaIcons.Search,
//                        navigationIconContentDescription = stringResource(
//                            id = settingsR.string.top_app_bar_navigation_icon_description,
//                        ),
//                        actionIcon = NiaIcons.Settings,
//                        actionIconContentDescription = stringResource(
//                            id = settingsR.string.top_app_bar_action_icon_description,
//                        ),
//                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                            containerColor = Color.Transparent,
//                        ),
//                        onActionClick = { showSettingsDialog = true },
//                        onNavigationClick = { appState.navigateToSearch() },
//                    )
                }

                LbtNavHost(appState = appState)
            }

            // TODO: We may want to add padding or spacer when the snackbar is shown so that
            //  content doesn't display behind it.
        }
    }
}

@Composable
private fun LbtBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    LbtNavigationBar(
        modifier = modifier,
    ) {
        destinations.forEach { destination ->
//            val hasUnread = destinationsWithUnreadResources.contains(destination)
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            LbtNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon,
                        contentDescription = null,
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = null,
                    )
                },
                label = { Text(destination.iconTextId) },
//                modifier = if (hasUnread) Modifier.notificationDot() else Modifier,
            )
        }
    }
}

private fun Modifier.notificationDot(): Modifier =
    composed {
        val tertiaryColor = MaterialTheme.colorScheme.tertiary
        drawWithContent {
            drawContent()
            drawCircle(
                tertiaryColor,
                radius = 5.dp.toPx(),
                // This is based on the dimensions of the NavigationBar's "indicator pill";
                // however, its parameters are private, so we must depend on them implicitly
                // (NavigationBarTokens.ActiveIndicatorWidth = 64.dp)
                center = center + Offset(
                    64.dp.toPx() * .45f,
                    32.dp.toPx() * -.45f - 6.dp.toPx(),
                ),
            )
        }
    }

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false


@Preview
@Composable
fun previewLbt() {
    LbtTheme {
    }
}