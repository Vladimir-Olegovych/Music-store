package com.gigcreator.musicstore.presentation.di

import com.gigcreator.domain.repository.UserDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

}