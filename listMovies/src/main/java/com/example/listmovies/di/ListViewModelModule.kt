package com.example.listmovies.di

import com.example.listmovies.data.usecase.GetPopularMoviesUseCase
import com.example.listmovies.presentation.viewmodel.ListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ListViewModelModule {

    @Provides
    fun provideListViewModel(getPopularMoviesUseCase: GetPopularMoviesUseCase): ListViewModel {
        return ListViewModel(getPopularMoviesUseCase)
    }
}