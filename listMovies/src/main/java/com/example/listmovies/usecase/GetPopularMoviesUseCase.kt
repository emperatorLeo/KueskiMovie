package com.example.listmovies.usecase

import com.example.listmovies.data.repository.ListRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val moviesRepository: ListRepository) {

    suspend fun invoke() = moviesRepository.getPopularMovies()

}