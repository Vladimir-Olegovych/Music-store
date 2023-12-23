package com.gigcreator.domain.usecase

import com.gigcreator.domain.models.GuitarAmplifier
import com.gigcreator.domain.repository.GuitarAmplifierDataRepository

class GuitarAmplifierDataUseCase(private val guitarAmplifierDataRepository: GuitarAmplifierDataRepository) {
    suspend fun readAmplifier(): List<GuitarAmplifier> {
        return guitarAmplifierDataRepository.readAmplifier()
    }

    suspend fun searchAmplifierByName(name: String): List<GuitarAmplifier> {
        return guitarAmplifierDataRepository.searchAmplifierByName(name)
    }

    suspend fun searchAmplifierByBrand(name: String): List<GuitarAmplifier> {
        return guitarAmplifierDataRepository.searchAmplifierByBrand(name)
    }

    suspend fun searchAmplifierByPrice(name: String): List<GuitarAmplifier> {
        return guitarAmplifierDataRepository.searchAmplifierByPrice(name)
    }
}