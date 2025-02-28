package com.example.listmovies.usecase

import com.example.listmovies.data.repository.ListRepository
import javax.inject.Inject

class GetGenresUseCase @Inject constructor(private val moviesRepository: ListRepository) {
    suspend operator fun invoke() = moviesRepository.getGenres()

}