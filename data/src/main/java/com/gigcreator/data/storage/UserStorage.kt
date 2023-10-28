package com.gigcreator.data.storage

import com.gigcreator.domain.models.UserData

interface UserStorage {
    fun save(userData: UserData)
    fun get(): UserData
}