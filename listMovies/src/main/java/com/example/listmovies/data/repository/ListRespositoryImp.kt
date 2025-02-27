package com.example.listmovies.data.repository

import com.example.listmovies.data.apidatasource.DataSource
import javax.inject.Inject

class ListRespositoryImp @Inject constructor(private val dataSource: DataSource) : ListRepository {

    override suspend fun getPopularMovies() = dataSource.getPopularMovies()

}