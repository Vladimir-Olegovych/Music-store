package com.gigcreator.domain.usecase

import com.gigcreator.domain.models.Result
import com.gigcreator.domain.models.UserData
import com.gigcreator.domain.repository.UserDataRepository

class UserDataUseCase(private val userDataRepository: UserDataRepository) {

    suspend fun readUser(key: String): List<UserData> {
        return userDataRepository.readUser(key)
    }

    suspend fun searchUser(email: String, key: String): UserData {
        return userDataRepository.searchUser(email, key)
    }

    suspend fun saveUser(email: String, password: String, key: String): Result {
        return userDataRepository.saveUser(email, password, key)
    }

}