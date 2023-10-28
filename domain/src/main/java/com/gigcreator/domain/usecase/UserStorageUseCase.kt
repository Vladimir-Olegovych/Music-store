package com.gigcreator.domain.usecase

import com.gigcreator.domain.models.UserData
import com.gigcreator.domain.repository.UserStorageRepository

class UserStorageUseCase(private val userStorageRepository: UserStorageRepository) {

    fun save(userData: UserData){
        userStorageRepository.save(userData)
    }

    fun get(): UserData{
        return userStorageRepository.get()
    }
}