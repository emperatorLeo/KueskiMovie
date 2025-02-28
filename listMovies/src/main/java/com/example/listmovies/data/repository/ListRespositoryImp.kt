package com.example.listmovies.data.repository

import arrow.core.Either
import com.example.listmovies.data.apidatasource.DataSource
import com.example.listmovies.domain.GenreDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListRespositoryImp @Inject constructor(private val dataSource: DataSource) : ListRepository {

    override suspend fun getPopularMovies() = dataSource.getPopularMovies()

    override suspend fun getGenres(): Flow<Either<Error, List<GenreDto>>> = dataSource.getGenres()
}