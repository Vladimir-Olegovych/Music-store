package com.gigcreator.musicstore.presentation.di


import com.gigcreator.domain.repository.AcousticGuitarDataRepository
import com.gigcreator.domain.repository.ElectricGuitarDataRepository
import com.gigcreator.domain.repository.GuitarAmplifierDataRepository
import com.gigcreator.domain.repository.UserDataRepository
import com.gigcreator.domain.repository.UserStorageRepository
import com.gigcreator.domain.usecase.AcousticGuitarDataUseCase
import com.gigcreator.domain.usecase.ElectricGuitarDataUseCase
import com.gigcreator.domain.usecase.GuitarAmplifierDataUseCase
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
    fun provideElectricGuitarDataUseCase(electricGuitarDataRepository: ElectricGuitarDataRepository): ElectricGuitarDataUseCase =
        ElectricGuitarDataUseCase(electricGuitarDataRepository = electricGuitarDataRepository)

    @Provides
    fun provideGuitarAmplifierDataUseCase(guitarAmplifierDataRepository: GuitarAmplifierDataRepository): GuitarAmplifierDataUseCase =
        GuitarAmplifierDataUseCase(guitarAmplifierDataRepository = guitarAmplifierDataRepository)

    @Provides
    fun provideUserStorageUseCase(userStorageRepository: UserStorageRepository): UserStorageUseCase =
        UserStorageUseCase(userStorageRepository = userStorageRepository)

}