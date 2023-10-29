package com.gigcreator.musicstore.presentation.di


import com.gigcreator.domain.repository.AcousticGuitarDataRepository
import com.gigcreator.domain.repository.UserDataRepository
import com.gigcreator.domain.repository.UserStorageRepository
import com.gigcreator.domain.usecase.AcousticGuitarDataUseCase
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
    fun provideUserDataUseCase(userDataRepository: UserDataRepository): UserDataUseCase =
        UserDataUseCase(userDataRepository = userDataRepository)

    @Provides
    fun provideAcousticGuitarDataUseCase(acousticGuitarDataRepository: AcousticGuitarDataRepository): AcousticGuitarDataUseCase =
        AcousticGuitarDataUseCase(acousticGuitarDataRepository = acousticGuitarDataRepository)

    @Provides
    fun provideUserStorageUseCase(userStorageRepository: UserStorageRepository): UserStorageUseCase =
        UserStorageUseCase(userStorageRepository = userStorageRepository)


}