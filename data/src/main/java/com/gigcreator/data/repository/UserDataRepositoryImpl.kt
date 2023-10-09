package com.gigcreator.data.repository

import com.gigcreator.domain.models.BaseModel
import com.gigcreator.domain.repository.ReadDataRepository

class UserDataRepositoryImpl(private val readDataRepository: ReadDataRepository): ReadDataRepository {
    override suspend fun readData(): BaseModel {
        return readDataRepository.readData()
    }

}