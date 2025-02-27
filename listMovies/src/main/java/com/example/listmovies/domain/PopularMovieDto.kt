package com.example.listmovies.domain

data class PopularMovieDto(
    val id: Int,
    val language: String,
    val title: String,
    val description: String,
    val posterImage: String,
    val releaseDate: String
) {
   companion object { val EMPTY = PopularMovieDto(0, "", "", "", "", "") }
}

