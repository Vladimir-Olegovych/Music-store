package com.gigcreator.data.repository

import com.gigcreator.data.storage.UserStorage
import com.gigcreator.domain.models.UserDataModel
import com.gigcreator.domain.repository.UserStorageRepository

class UserStorageRepositoryImpl(private val userStorage: UserStorage): UserStorageRepository {
    override fun save(userDataModel: UserDataModel) {
        userStorage.save(userDataModel)
    }

    override fun get(): UserDataModel {
        return userStorage.get()
    }
}