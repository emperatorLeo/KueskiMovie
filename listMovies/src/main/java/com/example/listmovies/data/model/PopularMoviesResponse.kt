package com.example.listmovies.data.model

import com.example.listmovies.domain.PopularMovieDto
import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse(@SerializedName("results") val list: List<PopularMovie>)

data class PopularMovie(
    @SerializedName("id") val movieId: Int,
    @SerializedName("original_language") val language: String,
    @SerializedName("original_title") val title: String,
    @SerializedName("overview") val description: String,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("poster_path") val posterImage: String,
    @SerializedName("release_date") val releaseDate: String,
) {
    fun toPopularMovieDto() = PopularMovieDto(
        id = movieId,
        language = language,
        title = title,
        description = description,
        genresIds = genreIds,
        posterImage = posterImage,
        releaseDate = releaseDate
    )
}