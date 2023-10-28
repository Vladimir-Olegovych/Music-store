package com.gigcreator.data.repository

import com.gigcreator.data.storage.UserStorage
import com.gigcreator.domain.models.UserData
import com.gigcreator.domain.repository.UserStorageRepository

class UserStorageRepositoryImpl(private val userStorage: UserStorage): UserStorageRepository {
    override fun save(userData: UserData) {
        userStorage.save(userData)
    }

    override fun get(): UserData {
        return userStorage.get()
    }
}