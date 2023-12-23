package com.gigcreator.domain.usecase

import com.gigcreator.domain.models.GuitarData
import com.gigcreator.domain.repository.ElectricGuitarDataRepository


class ElectricGuitarDataUseCase(private val electricGuitarDataRepository: ElectricGuitarDataRepository) {
    suspend fun readAcousticGuitar(): List<GuitarData> {
        return electricGuitarDataRepository.readAcousticGuitar()
    }

    suspend fun searchAcousticGuitarByName(name: String): List<GuitarData> {
        return electricGuitarDataRepository.searchAcousticGuitarByName(name)
    }

    suspend fun searchAcousticGuitarByBrand(name: String): List<GuitarData> {
        return electricGuitarDataRepository.searchAcousticGuitarByBrand(name)
    }

    suspend fun searchAcousticGuitarByPrice(name: String): List<GuitarData> {
        return electricGuitarDataRepository.searchAcousticGuitarByPrice(name)
    }

    suspend fun searchAcousticGuitarByStrings(name: Int): List<GuitarData> {
        return electricGuitarDataRepository.searchAcousticGuitarByStrings(name)
    }
}