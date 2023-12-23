package com.gigcreator.domain.usecase

import com.gigcreator.domain.models.GuitarData
import com.gigcreator.domain.repository.AcousticGuitarDataRepository

class AcousticGuitarDataUseCase(private val acousticGuitarDataRepository: AcousticGuitarDataRepository) {
    suspend fun readAcousticGuitar(): List<GuitarData> {
        return acousticGuitarDataRepository.readAcousticGuitar()
    }

    suspend fun searchAcousticGuitarByName(name: String): List<GuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByName(name)
    }

    suspend fun searchAcousticGuitarByBrand(name: String): List<GuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByBrand(name)
    }

    suspend fun searchAcousticGuitarByPrice(name: String): List<GuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByPrice(name)
    }

    suspend fun searchAcousticGuitarByStrings(name: Int): List<GuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByStrings(name)
    }
}