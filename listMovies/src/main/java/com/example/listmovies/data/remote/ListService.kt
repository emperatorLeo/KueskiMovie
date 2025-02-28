package com.example.listmovies.data.remote

import com.example.listmovies.data.model.GenreResponse
import com.example.listmovies.data.model.PopularMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ListService {

    @GET("discover/movie")
    suspend fun getPopularMovies(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("sort_by") sortBy: String = "popularity.desc"
    ): Response<PopularMoviesResponse>

    @GET("genre/movie/list?language=es")
    suspend fun getGenres(): Response<GenreResponse>

}