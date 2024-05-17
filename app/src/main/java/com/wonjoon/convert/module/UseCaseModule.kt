package com.wonjoon.convert.module

import com.wonjoon.domain.repository.ConvertRepository
import com.wonjoon.domain.repository.CountryRepository
import com.wonjoon.domain.usecase.ConvertUseCase
import com.wonjoon.domain.usecase.CountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideConvertUseCase(repository: ConvertRepository) : ConvertUseCase {
        return ConvertUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCountryUseCase(repository: CountryRepository) : CountryUseCase {
        return CountryUseCase(repository)
    }
}