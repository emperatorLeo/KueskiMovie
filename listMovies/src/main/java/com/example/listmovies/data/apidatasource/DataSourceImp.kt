package com.example.listmovies.data.apidatasource

import arrow.core.Either
import com.example.listmovies.data.remote.ListService
import com.example.listmovies.domain.GenreDto
import com.example.listmovies.domain.PopularMovieDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataSourceImp(private val service: ListService) : DataSource {
    override suspend fun getPopularMovies(): Flow<Either<Error, List<PopularMovieDto>>> = flow {
        val response = service.getPopularMovies()
        if (response.isSuccessful) {
            val responseBody = response.body()?.list ?: emptyList()
            val dtoList = responseBody.map { it.toPopularMovieDto() }
            emit(Either.Right(dtoList))
        } else {
            emit(Either.Left(Error(response.message())))
        }
    }

    override suspend fun getGenres(): Flow<Either<Error, List<GenreDto>>> = flow {
        val response = service.getGenres()
        if (response.isSuccessful) {
            val responseBody = response.body()?.list ?: emptyList()
            val dtoList = responseBody.map { it.toGenreDto() }
            emit(Either.Right(dtoList))
        } else {
            emit(Either.Left(Error(response.message())))
        }
    }
}