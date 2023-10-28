package com.gigcreator.musicstore.presentation.di


import com.gigcreator.domain.repository.UserDataRepository
import com.gigcreator.domain.repository.UserStorageRepository
import com.gigcreator.domain.usecase.UserDataUseCase
import com.gigcreator.domain.usecase.UserStorageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideUserDataUseCase(userDataRepository: UserDataRepository): UserDataUseCase{
        return UserDataUseCase(userDataRepository = userDataRepository)
    }

    @Provides
    fun provideUserStorageUseCase(userStorageRepository: UserStorageRepository): UserStorageUseCase {
        return UserStorageUseCase(userStorageRepository = userStorageRepository)
    }

}