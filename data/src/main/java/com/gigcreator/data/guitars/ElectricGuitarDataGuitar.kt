package com.gigcreator.data.guitars

import com.gigcreator.domain.repository.ElectricGuitarDataRepository


class ElectricGuitarDataGuitar(private val electricGuitarDataRepository: ElectricGuitarDataRepository): ElectricGuitarData {
    override suspend fun readAcousticGuitar(): List<com.gigcreator.domain.models.GuitarData> {
        return electricGuitarDataRepository.readAcousticGuitar()
    }

    override suspend fun searchAcousticGuitarByName(name: String): List<com.gigcreator.domain.models.GuitarData> {
        return electricGuitarDataRepository.searchAcousticGuitarByName(name)
    }

    override suspend fun searchAcousticGuitarByBrand(name: String): List<com.gigcreator.domain.models.GuitarData> {
        return electricGuitarDataRepository.searchAcousticGuitarByBrand(name)
    }

    override suspend fun searchAcousticGuitarByPrice(name: String): List<com.gigcreator.domain.models.GuitarData> {
        return electricGuitarDataRepository.searchAcousticGuitarByPrice(name)
    }

    override suspend fun searchAcousticGuitarByStrings(name: Int): List<com.gigcreator.domain.models.GuitarData> {
        return electricGuitarDataRepository.searchAcousticGuitarByStrings(name)
    }
}