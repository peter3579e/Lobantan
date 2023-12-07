package com.android.home.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.common.ui.TrackScrollJank
import com.android.designsystem.theme.LbtTheme
import com.android.designsystem.theme.ui.DevicePreviews
import com.android.home.component.products.ProductUI

@Composable
internal fun HomeUI(
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val fakeHomeUiState: HomeUiState by viewModel.fakeUiState.collectAsState()
    Column(
        modifier
    ) {
        HomeItem(fakeHomeUiState)
    }
}

@Composable
internal fun HomeItem(
    homeUiState: HomeUiState,
    modifier: Modifier = Modifier
) {
    val state = rememberLazyListState()
    TrackScrollJank(scrollableState = state, stateName = "topic:screen")
    Box(
        modifier = modifier,
    ) {
        LazyRow(
            state = state,
        ) {
            when (homeUiState) {
                is HomeUiState.Success -> {
                    items(homeUiState.products.size) { index ->
                        ProductUI(imageUrl = homeUiState.products[index].image)
                    }
                }

                else -> {}
            }
        }

//        LazyColumn(
//            state = state,
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            item {
//                Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
//            }
//            when (homeUiState) {
//                is HomeUiState.Success -> {
//                    item {
//                        ProductUI(imageUrl = "https://picsum.photos/300/200?random=2")
//                    }
//                }
//
//                else -> {}
//            }
//            item {
//                Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
//            }
    }
}

private fun homeItemSize(
    topicUiState: HomeUiState,
) = when (topicUiState) {
    HomeUiState.Error -> 0 // Nothing
    HomeUiState.Loading -> 1 // Loading bar
    is HomeUiState.Success -> when (topicUiState) {
        HomeUiState.Error -> 0 // Nothing
        HomeUiState.Loading -> 1 // Loading bar
        is HomeUiState.Success -> 2 + topicUiState.products.size // Toolbar, header
    }
}


@Composable
@DevicePreviews
fun previewHome() {
    LbtTheme {
//        HomeItem("peter", "https://picsum.photos/300/200?random=2")
    }
}