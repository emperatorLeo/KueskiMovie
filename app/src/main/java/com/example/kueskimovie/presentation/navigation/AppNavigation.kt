package com.example.kueskimovie.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.details.presentation.screen.DetailsScreen
import com.example.kueskimovie.presentation.navigation.AppRoutes.DETAIL_SCREEN
import com.example.kueskimovie.presentation.navigation.AppRoutes.MAIN_SCREEN
import com.example.kueskimovie.presentation.navigation.AppRoutes.MOVIE_ID
import com.example.listmovies.presentation.screen.PopularListScreen
import com.example.listmovies.presentation.viewmodel.MovieViewModel

@Composable
fun AppNavigation(
    paddingValues: PaddingValues,
    viewModel: MovieViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MAIN_SCREEN
    ) {

        composable(route = MAIN_SCREEN) {
            PopularListScreen(paddingValues = paddingValues, viewModel = viewModel, navController)
        }

        composable(route = DETAIL_SCREEN,
            arguments = listOf(
                navArgument(MOVIE_ID) {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            val movieId = navBackStackEntry.arguments?.getInt(MOVIE_ID) ?: 0
            DetailsScreen(
                viewModel = viewModel,
                navController = navController,
                movieId = movieId
            )
        }
    }
}