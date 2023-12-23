package com.gigcreator.musicstore.presentation.di

import android.content.Context
import com.gigcreator.data.guitars.AcousticGuitarData
import com.gigcreator.data.guitars.AcousticGuitarDataGuitar
import com.gigcreator.data.guitars.ElectricGuitarData
import com.gigcreator.data.guitars.ElectricGuitarDataGuitar
import com.gigcreator.data.guitars.GuitarAmplifierData
import com.gigcreator.data.guitars.GuitarAmplifierDataGuitar
import com.gigcreator.data.repository.AcousticGuitarDataRepositoryImpl
import com.gigcreator.data.repository.ElectricGuitarDataRepositoryImpl
import com.gigcreator.data.repository.GuitarAmplifierDataRepositoryImpl
import com.gigcreator.data.repository.UserDataRepositoryImpl
import com.gigcreator.data.storage.UserStorage
import com.gigcreator.data.repository.UserStorageRepositoryImpl
import com.gigcreator.data.storage.SharedPrefUserStorage
import com.gigcreator.data.user.UserData
import com.gigcreator.data.user.UserDataUser
import com.gigcreator.domain.repository.AcousticGuitarDataRepository
import com.gigcreator.domain.repository.ElectricGuitarDataRepository
import com.gigcreator.domain.repository.GuitarAmplifierDataRepository
import com.gigcreator.domain.repository.UserDataRepository
import com.gigcreator.domain.repository.UserStorageRepository
import com.gigcreator.musicstore.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.resources.getString(R.string.address))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAcousticGuitarData(retrofit: Retrofit): AcousticGuitarData =
        AcousticGuitarDataGuitar(retrofit.create(AcousticGuitarDataRepository::class.java))

    @Provides
    @Singleton
    fun provideAcousticGuitarDataRepository(acousticGuitarData: AcousticGuitarData): AcousticGuitarDataRepository =
        AcousticGuitarDataRepositoryImpl(acousticGuitarData)

    @Provides
    @Singleton
    fun provideElectricGuitarData(retrofit: Retrofit): ElectricGuitarData =
        ElectricGuitarDataGuitar(retrofit.create(ElectricGuitarDataRepository::class.java))

    @Provides
    @Singleton
    fun provideElectricGuitarDataRepository(electricGuitarData: ElectricGuitarData): ElectricGuitarDataRepository =
        ElectricGuitarDataRepositoryImpl(electricGuitarData)

    @Provides
    @Singleton
    fun provideGuitarAmplifierData(retrofit: Retrofit): GuitarAmplifierData =
        GuitarAmplifierDataGuitar(retrofit.create(GuitarAmplifierDataRepository::class.java))

    @Provides
    @Singleton
    fun provideGuitarAmplifierDataRepository(guitarAmplifierData: GuitarAmplifierData): GuitarAmplifierDataRepository =
        GuitarAmplifierDataRepositoryImpl(guitarAmplifierData)


    @Provides
    @Singleton
    fun provideUserData(retrofit: Retrofit): UserData =
        UserDataUser(retrofit.create(UserDataRepository::class.java))

    @Provides
    @Singleton
    fun provideUserDataRepository(userData: UserData): UserDataRepository =
        UserDataRepositoryImpl(userData)

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context):
            UserStorage = SharedPrefUserStorage(context)

    @Provides
    @Singleton
    fun provideUserStorageRepository(userStorage: UserStorage): UserStorageRepository =
        UserStorageRepositoryImpl(userStorage)

}