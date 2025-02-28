package com.example.listmovies.data.model

import com.example.listmovies.domain.GenreDto
import com.google.gson.annotations.SerializedName

data class GenreResponse(@SerializedName("genres") val list: List<GenreItem>)

data class GenreItem(@SerializedName("id") val id: Int, @SerializedName("name") val name: String) {
    fun toGenreDto() = GenreDto(id, name)
}
