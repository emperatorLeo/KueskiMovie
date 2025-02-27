package com.example.listmovies.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listmovies.presentation.viewmodel.ListViewModel


@Composable
@Preview(showBackground = true)
fun PopularListScreen(viewModel: ListViewModel = viewModel()) {

    LaunchedEffect(Unit) {
        viewModel.getPopularMovies()
    }
}