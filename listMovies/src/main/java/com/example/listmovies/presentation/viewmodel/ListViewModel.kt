package com.example.listmovies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.listmovies.data.usecase.GetPopularMoviesUseCase
import com.example.listmovies.presentation.states.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getPopularMoviesUseCase: GetPopularMoviesUseCase) :
    ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState get() = _uiState.asStateFlow()

    fun getPopularMovies() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            getPopularMoviesUseCase.invoke().collect {
                when (it) {
                    is Either.Left -> {
                        _uiState.value = UiState.Error(it.value.message ?: "Error message")
                    }

                    is Either.Right -> {
                        _uiState.value = UiState.Success(it.value)
                    }
                }
            }
        }
    }
}