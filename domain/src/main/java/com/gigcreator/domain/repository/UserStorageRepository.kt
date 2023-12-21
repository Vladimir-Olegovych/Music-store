package com.gigcreator.domain.repository

import com.gigcreator.domain.models.UserDataModel

interface UserStorageRepository {
    fun save(userDataModel: UserDataModel)
    fun get(): UserDataModel
}