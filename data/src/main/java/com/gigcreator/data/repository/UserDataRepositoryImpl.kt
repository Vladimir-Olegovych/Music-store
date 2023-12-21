package com.gigcreator.data.repository

import com.gigcreator.data.user.UserData
import com.gigcreator.domain.models.Result
import com.gigcreator.domain.models.UserDataModel
import com.gigcreator.domain.repository.UserDataRepository

class UserDataRepositoryImpl(private val userData: UserData): UserDataRepository {
    override suspend fun readUser(key: String): List<UserDataModel> {
        return userData.readUser(key)
    }

    override suspend fun searchUser(email: String, key: String): UserDataModel {
        return userData.searchUser(email, key)
    }

    override suspend fun saveUser(email: String, password: String, key: String): Result {
        return userData.saveUser(email, password, key)
    }
}