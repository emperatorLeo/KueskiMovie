package com.example.listmovies.presentation.viewmodel

import android.net.ConnectivityManager
import android.net.Network
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.listmovies.domain.GenreDto
import com.example.listmovies.domain.PopularMovieDto
import com.example.listmovies.presentation.states.UiState
import com.example.listmovies.usecase.GetGenresUseCase
import com.example.listmovies.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getGenreUseCase: GetGenresUseCase,
    private val connectivity: ConnectivityManager,
) :
    ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState get() = _uiState.asStateFlow()

    private val _connectionStatus = MutableStateFlow(true)
    private val connectionStatus = _connectionStatus.asStateFlow()

    private val cacheMovieList = mutableListOf<PopularMovieDto>()
    private val cacheGenreList = mutableListOf<GenreDto>()
    val genreMovie = mutableListOf<GenreDto>()

    fun getPopularMovies() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            if (!connectionStatus.value) {
                _uiState.value = UiState.NoInternetError
            } else {
                getPopularMoviesUseCase.invoke().collect {
                    when (it) {
                        is Either.Left -> {
                            _uiState.value = UiState.Error(it.value.message ?: "Error message")
                        }

                        is Either.Right -> {
                            cacheMovieList.clear()
                            cacheMovieList.addAll(it.value)
                            _uiState.value = UiState.Success(it.value)
                            getGenres()
                        }
                    }
                }
            }
        }
    }

    private suspend fun getGenres() {
        getGenreUseCase.invoke().collect {
            when (it) {
                is Either.Left -> {
                    _uiState.value = UiState.Error(it.value.message ?: "Error message")
                }

                is Either.Right -> {
                    cacheGenreList.clear()
                    cacheGenreList.addAll(it.value)
                }
            }

        }
    }

    fun searchMovies(movieName: String) {
        val result = cacheMovieList.filter { movie ->
            movie.title.lowercase().trim().contains(movieName.lowercase().trim())
        }
        _uiState.value = UiState.Success(result)
    }

    fun checkConnection() {
        connectivity.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
            override fun onLost(network: Network) {
                super.onLost(network)
                _connectionStatus.value = false
            }

            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                _connectionStatus.value = true
            }
        })
    }

    fun getSelectedMovie(movieId: Int): PopularMovieDto {
        val movie = cacheMovieList.find { it.id == movieId } ?: PopularMovieDto.EMPTY
        genreMovie.clear()
        for (genreId in movie.genresIds) {
            val genre = cacheGenreList.find { it.genreId == genreId }
            if (genre != null) {
                genreMovie.add(genre)
            }
        }
        return movie
    }

}