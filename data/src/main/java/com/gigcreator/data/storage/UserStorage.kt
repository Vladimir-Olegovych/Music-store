package com.gigcreator.data.storage

import com.gigcreator.domain.models.UserDataModel

interface UserStorage {
    fun save(userDataModel: UserDataModel)
    fun get(): UserDataModel
}