package com.example.listmovies.presentation.states

import com.example.listmovies.domain.PopularMovieDto

sealed class UiState {
    data class Success(val data: List<PopularMovieDto>) : UiState()
    data class Error(val message: String) : UiState()
    data object Idle : UiState()
    data object Loading : UiState()
}