package com.example.listmovies.data.repository

import arrow.core.Either
import com.example.listmovies.domain.PopularMovieDto
import kotlinx.coroutines.flow.Flow


interface ListRepository {
    suspend fun getPopularMovies(): Flow<Either<Error,List<PopularMovieDto>>>
}