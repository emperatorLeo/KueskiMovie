package com.example.listmovies.data.repository

import arrow.core.Either
import com.example.listmovies.domain.GenreDto
import com.example.listmovies.domain.PopularMovieDto
import kotlinx.coroutines.flow.Flow


interface ListRepository {
    suspend fun getPopularMovies(): Flow<Either<Error,List<PopularMovieDto>>>

    suspend fun getGenres(): Flow<Either<Error,List<GenreDto>>>
}