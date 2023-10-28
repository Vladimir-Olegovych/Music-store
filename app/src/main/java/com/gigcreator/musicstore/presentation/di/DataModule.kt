package com.gigcreator.musicstore.presentation.di

import android.content.Context
import com.gigcreator.data.storage.UserStorage
import com.gigcreator.data.repository.UserStorageRepositoryImpl
import com.gigcreator.data.storage.SharedPrefUserStorage
import com.gigcreator.domain.repository.UserDataRepository
import com.gigcreator.domain.repository.UserStorageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    @Named("UserData")
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://178.163.63.165:27015/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDataRepository(@Named("UserData") retrofit: Retrofit): UserDataRepository = retrofit.create(UserDataRepository::class.java)

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserStorageRepository(userStorage: UserStorage): UserStorageRepository {
        return UserStorageRepositoryImpl(userStorage = userStorage)
    }
}