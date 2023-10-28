package com.gigcreator.domain.repository

import com.gigcreator.domain.models.UserData

interface UserStorageRepository {
    fun save(userData: UserData)
    fun get(): UserData
}