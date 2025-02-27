package com.example.listmovies.di

import com.example.listmovies.data.apidatasource.DataSource
import com.example.listmovies.data.apidatasource.DataSourceImp
import com.example.listmovies.data.remote.ListService
import com.example.listmovies.data.repository.ListRepository
import com.example.listmovies.data.repository.ListRespositoryImp
import com.example.networking.di.DataSourceModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [DataSourceModule::class])
@InstallIn(SingletonComponent::class)
object ListModule {

    @Singleton
    @Provides
    fun provideListService(retrofit: Retrofit): ListService {
        return retrofit.create(ListService::class.java)
    }

    @Singleton
    @Provides
    fun provideDataSource(listService: ListService): DataSource {
        return DataSourceImp(listService)
    }

    @Singleton
    @Provides
    fun provideRepository(dataSource: DataSource): ListRepository {
        return ListRespositoryImp(dataSource)
    }

}