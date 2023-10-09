package com.gigcreator.musicstore.presentation.di

import com.gigcreator.domain.repository.ReadDataRepository
import com.gigcreator.domain.usecase.ReadDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideReadDataUseCase(readDataRepository: ReadDataRepository): ReadDataUseCase{
        return ReadDataUseCase(readDataRepository = readDataRepository)
    }

}