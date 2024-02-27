package com.wonjoon.convert.module

import com.wonjoon.data.repository.ConvertRepositoryImpl
import com.wonjoon.data.retrofit.ConvertAPI
import com.wonjoon.domain.repository.ConvertRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideConvertRepository(api : ConvertAPI) : ConvertRepository{
        return ConvertRepositoryImpl(api)
    }
}