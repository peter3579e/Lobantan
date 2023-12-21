package com.android.home.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.common.result.Result
import com.android.common.result.asResult
import com.android.data.model.Categories
import com.android.data.repository.fake.FakeHomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fakeHomeRepository: FakeHomeRepository
) : ViewModel() {

    val fakeUiState: StateFlow<HomeUiState> = categoriesUiState(
        fakeHomeRepository
    )
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState.Loading,
        )


    private fun categoriesUiState(
        fakeHomeRepository: FakeHomeRepository,
    ): Flow<HomeUiState> {
        // Observe categories
        val productStream: Flow<List<Categories>> = fakeHomeRepository.getCategories()

        return productStream
            .asResult()
            .map { categories ->
                when (categories) {
                    is Result.Success -> {
                        val categories = categories.data
                        HomeUiState.Success(categories)
                    }

                    is Result.Loading -> {
                        HomeUiState.Loading
                    }

                    is Result.Error -> {
                        HomeUiState.Error
                    }
                }
            }
    }
}

sealed interface HomeUiState {
    data class Success(val categories: List<Categories>) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}