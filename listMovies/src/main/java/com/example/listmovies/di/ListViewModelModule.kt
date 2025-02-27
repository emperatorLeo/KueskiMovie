package com.example.listmovies.di

import android.content.Context
import android.net.ConnectivityManager
import com.example.listmovies.usecase.GetPopularMoviesUseCase
import com.example.listmovies.presentation.viewmodel.ListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object ListViewModelModule {

    @Provides
    fun provideListViewModel(
        getPopularMoviesUseCase: GetPopularMoviesUseCase,
        connectionManager: ConnectivityManager
    ): ListViewModel {
        return ListViewModel(getPopularMoviesUseCase, connectionManager)
    }

    @Provides
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(ConnectivityManager::class.java)
    }
}