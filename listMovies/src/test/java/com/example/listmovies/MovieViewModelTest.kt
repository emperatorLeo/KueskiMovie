package com.example.listmovies

import android.net.ConnectivityManager
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import arrow.core.Either
import com.example.listmovies.domain.GenreDto
import com.example.listmovies.domain.PopularMovieDto
import com.example.listmovies.presentation.states.UiState
import com.example.listmovies.presentation.viewmodel.MovieViewModel
import com.example.listmovies.usecase.GetGenresUseCase
import com.example.listmovies.usecase.GetPopularMoviesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MovieViewModelTest {

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK
    private lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase

    @RelaxedMockK
    private lateinit var getGenresUseCase: GetGenresUseCase

    @RelaxedMockK
    private lateinit var connectivity: ConnectivityManager

    private lateinit var viewModel: MovieViewModel

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        viewModel = MovieViewModel(
            getPopularMoviesUseCase = getPopularMoviesUseCase,
            getGenreUseCase = getGenresUseCase,
            connectivity = connectivity
        )

        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel calls getPopularMovies, uiState should return success`() = runTest {
        // GIVEN
        val movieList = listOf(
            PopularMovieDto(
                id = 1,
                language = "",
                title = "",
                description = "",
                genresIds = listOf(0),
                posterImage = "",
                releaseDate = "",
            ),
            PopularMovieDto(
                id = 2,
                language = "",
                title = "",
                description = "",
                genresIds = listOf(1),
                posterImage = "",
                releaseDate = "",
            )
        )

       val mockedFlow = flow<Either<Error, List<PopularMovieDto>>> { emit(Either.Right(movieList)) }

        coEvery { getPopularMoviesUseCase.invoke() } returns mockedFlow

        // WHEN
        viewModel.getPopularMovies()

        // THEN
        assertEquals(viewModel.uiState.value, UiState.Success(movieList))
    }

    @Test
    fun `when viewmodel calls getPopularMovies and fails, uiState should return error`() = runTest {
        // GIVEN
        val errorMessage = "Error Message"

        val mockedFlow = flow<Either<Error, List<PopularMovieDto>>> { emit(Either.Left(Error(errorMessage))) }

        coEvery { getPopularMoviesUseCase.invoke() } returns mockedFlow

        // WHEN
        viewModel.getPopularMovies()

        // THEN
        assertEquals(viewModel.uiState.value, UiState.Error(errorMessage))
    }

    @Test
    fun `when viewmodel calls getGenres and fails, uiState should return error`() = runTest {
        // GIVEN
        val movieList = listOf(
            PopularMovieDto(
                id = 1,
                language = "",
                title = "",
                description = "",
                genresIds = listOf(0),
                posterImage = "",
                releaseDate = "",
            ),
            PopularMovieDto(
                id = 2,
                language = "",
                title = "",
                description = "",
                genresIds = listOf(1),
                posterImage = "",
                releaseDate = "",
            )
        )
        val errorMessage = "Error Message"

        val mockedFlow = flow<Either<Error, List<PopularMovieDto>>> { emit(Either.Right(movieList)) }
        val mockedGenreFlow = flow<Either<Error, List<GenreDto>>> { emit(Either.Left(Error(errorMessage))) }

        coEvery { getPopularMoviesUseCase.invoke() } returns mockedFlow
        coEvery { getGenresUseCase.invoke() } returns mockedGenreFlow
        // WHEN
        viewModel.getPopularMovies()

        // THEN
        assertEquals(viewModel.uiState.value, UiState.Error(errorMessage))
    }
}