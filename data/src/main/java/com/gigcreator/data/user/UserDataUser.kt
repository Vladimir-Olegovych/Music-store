package com.gigcreator.data.user

import com.gigcreator.domain.models.Result
import com.gigcreator.domain.models.UserDataModel
import com.gigcreator.domain.repository.UserDataRepository

class UserDataUser(private val userDataRepository: UserDataRepository): UserData {
    override suspend fun readUser(key: String): List<UserDataModel> {
        return userDataRepository.readUser(key)
    }

    override suspend fun searchUser(email: String, key: String): UserDataModel {
        return userDataRepository.searchUser(email, key)
    }

    override suspend fun saveUser(email: String, password: String, key: String): Result {
        return userDataRepository.saveUser(email, password, key)
    }
}