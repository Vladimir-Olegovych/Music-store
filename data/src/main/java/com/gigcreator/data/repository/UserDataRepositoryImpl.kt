package com.gigcreator.data.repository

import com.gigcreator.domain.models.Result
import com.gigcreator.domain.models.UserData
import com.gigcreator.domain.repository.UserDataRepository

class UserDataRepositoryImpl(private val userDataRepository: UserDataRepository): UserDataRepository {

    override suspend fun readUser(key: String): List<UserData> {
        return userDataRepository.readUser(key)
    }

    override suspend fun searchUser(email: String, key: String): UserData {
        return  userDataRepository.searchUser(email, key)
    }

    override suspend fun saveUser(email: String, password: String, key: String): Result {
        return userDataRepository.saveUser(email, password, key)
    }

}