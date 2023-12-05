package com.android.home.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.data.model.Categories
import com.android.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    fun getFakeHomeRepository() =
        viewModelScope.launch {
            homeRepository.getHomeCategoriesList()
        }


//    val fakeUiState: StateFlow<FakeUiState> = topicUiState(
//        topicId = topicArgs.topicId,
//        userDataRepository = userDataRepository,
//        topicsRepository = topicsRepository,
//    )
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = FakeUiState.Loading,
//        )


//    private fun topicUiState(
//        topicId: String,
//        homeRepository: HomeRepository,
//    ): Flow<FakeUiState> {
//        // Observe news
//        val newsStream: Flow<List<Categories>> = homeRepository.observeAll(
//            NewsResourceQuery(filterTopicIds = setOf(element = topicId)),
//        )
//
//        // Observe bookmarks
//        val bookmark: Flow<Set<String>> = userDataRepository.userData
//            .map { it.bookmarkedNewsResources }
//
//        return combine(
//            newsStream,
//            bookmark,
//            ::Pair,
//        )
//            .asResult()
//            .map { newsToBookmarksResult ->
//                when (newsToBookmarksResult) {
//                    is Result.Success -> {
//                        val news = newsToBookmarksResult.data.first
//                        NewsUiState.Success(news)
//                    }
//
//                    is Result.Loading -> {
//                        NewsUiState.Loading
//                    }
//
//                    is Result.Error -> {
//                        NewsUiState.Error
//                    }
//                }
//            }
//    }
}

sealed interface FakeUiState {
    data class Success(val products: List<Categories>) : FakeUiState
    object Error : FakeUiState
    object Loading : FakeUiState
}