package com.gigcreator.domain.usecase

import com.gigcreator.domain.models.UserDataModel
import com.gigcreator.domain.repository.UserStorageRepository

class UserStorageUseCase(private val userStorageRepository: UserStorageRepository) {

    fun save(userDataModel: UserDataModel){
        userStorageRepository.save(userDataModel)
    }

    fun get(): UserDataModel{
        return userStorageRepository.get()
    }
}