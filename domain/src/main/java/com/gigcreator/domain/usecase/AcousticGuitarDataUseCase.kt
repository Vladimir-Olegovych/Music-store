package com.gigcreator.domain.usecase

import com.gigcreator.domain.models.AcousticGuitarData
import com.gigcreator.domain.repository.AcousticGuitarDataRepository

class AcousticGuitarDataUseCase(private val acousticGuitarDataRepository: AcousticGuitarDataRepository) {
    suspend fun readAcousticGuitar(): List<AcousticGuitarData> {
        return acousticGuitarDataRepository.readAcousticGuitar()
    }

    suspend fun searchAcousticGuitarByName(name: String): List<AcousticGuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByName(name)
    }

    suspend fun searchAcousticGuitarByBrand(name: String): List<AcousticGuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByBrand(name)
    }

    suspend fun searchAcousticGuitarByPrice(name: String): List<AcousticGuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByPrice(name)
    }

    suspend fun searchAcousticGuitarByStrings(name: Int): List<AcousticGuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByStrings(name)
    }
}