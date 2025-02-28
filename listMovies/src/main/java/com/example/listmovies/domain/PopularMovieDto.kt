package com.example.listmovies.domain

data class PopularMovieDto(
    val id: Int,
    val language: String,
    val title: String,
    val description: String,
    val genresIds: List<Int>,
    val posterImage: String,
    val releaseDate: String
) {
    companion object {
        val EMPTY = PopularMovieDto(0, "", "", "", emptyList(), "", "")
    }
}

