package com.example.listmovies.presentation.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.listmovies.presentation.component.ErrorComponent
import com.example.listmovies.presentation.component.LoaderComponent
import com.example.listmovies.presentation.component.MovieItem
import com.example.listmovies.presentation.component.NoInternetComponent
import com.example.listmovies.presentation.component.SearchBarComponent
import com.example.listmovies.presentation.navigation.AppRoutes
import com.example.listmovies.presentation.navigation.AppRoutes.DETAIL_SCREEN
import com.example.listmovies.presentation.states.UiState
import com.example.listmovies.presentation.viewmodel.MovieViewModel
import com.example.listmovies.util.EMPTY_STRING

@Composable
fun PopularListScreen(
    paddingValues: PaddingValues = PaddingValues(),
    viewModel: MovieViewModel = viewModel(),
    navController: NavController
) {
    viewModel.checkConnection()
    LaunchedEffect(Unit) {
        viewModel.getPopularMovies()
    }
    val state = viewModel.uiState.collectAsStateWithLifecycle()
    var text by remember { mutableStateOf(EMPTY_STRING) }
    var searchBarEnabled by remember { mutableStateOf(false) }

    LazyColumn(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            SearchBarComponent(
                modifier = Modifier.padding(paddingValues),
                enabled = searchBarEnabled,
                text
            ) { input ->
                text = input
                if (input.isEmpty()) {
                    viewModel.getPopularMovies()
                } else {
                    viewModel.searchMovies(input)
                }
            }
        }

        when (state.value) {
            is UiState.Idle -> {}
            is UiState.Error -> item {
                ErrorComponent()
            }

            is UiState.Loading -> {
                searchBarEnabled = false
                item {
                    LoaderComponent()
                }
            }

            is UiState.Success -> {
                searchBarEnabled = true
                items((state.value as UiState.Success).data) {
                    MovieItem(it) { movieId ->
                        val route = DETAIL_SCREEN.replace(
                            "{${AppRoutes.MOVIE_ID}}",
                            movieId.toString()
                        )
                        navController.navigate(route)
                    }
                }
            }

            is UiState.NoInternetError -> {
                item {
                    NoInternetComponent()
                }
            }
        }
    }
}