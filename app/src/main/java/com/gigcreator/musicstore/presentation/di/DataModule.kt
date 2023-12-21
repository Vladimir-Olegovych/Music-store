package com.gigcreator.musicstore.presentation.di

import android.content.Context
import com.gigcreator.data.guitars.AcousticGuitarData
import com.gigcreator.data.guitars.AcousticGuitarDataGuitar
import com.gigcreator.data.repository.AcousticGuitarDataRepositoryImpl
import com.gigcreator.data.repository.UserDataRepositoryImpl
import com.gigcreator.data.storage.UserStorage
import com.gigcreator.data.repository.UserStorageRepositoryImpl
import com.gigcreator.data.storage.SharedPrefUserStorage
import com.gigcreator.data.user.UserData
import com.gigcreator.data.user.UserDataUser
import com.gigcreator.domain.repository.AcousticGuitarDataRepository
import com.gigcreator.domain.repository.UserDataRepository
import com.gigcreator.domain.repository.UserStorageRepository
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
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://178.163.63.165:27015/")
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
    fun provideUserData(retrofit: Retrofit): UserData =
        UserDataUser(retrofit.create(UserDataRepository::class.java))

    @Provides
    @Singleton
    fun provideUserDataRepository(userData: UserData): UserDataRepository =
        UserDataRepositoryImpl(userData = userData)

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context):
            UserStorage = SharedPrefUserStorage(context = context)

    @Provides
    @Singleton
    fun provideUserStorageRepository(userStorage: UserStorage): UserStorageRepository =
        UserStorageRepositoryImpl(userStorage = userStorage)

}