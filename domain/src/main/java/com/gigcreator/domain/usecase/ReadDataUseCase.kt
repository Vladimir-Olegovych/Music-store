package com.gigcreator.domain.usecase

import com.gigcreator.domain.models.BaseModel
import com.gigcreator.domain.repository.ReadDataRepository

class ReadDataUseCase(private val readDataRepository: ReadDataRepository) {
    suspend fun execute(): BaseModel{
        return readDataRepository.readData()
    }
}