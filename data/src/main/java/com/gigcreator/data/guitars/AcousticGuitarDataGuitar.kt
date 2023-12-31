package com.gigcreator.data.guitars

import com.gigcreator.domain.repository.AcousticGuitarDataRepository

class AcousticGuitarDataGuitar(private val acousticGuitarDataRepository: AcousticGuitarDataRepository): AcousticGuitarData {
    override suspend fun readAcousticGuitar(): List<com.gigcreator.domain.models.GuitarData> {
        return acousticGuitarDataRepository.readAcousticGuitar()
    }

    override suspend fun searchAcousticGuitarByName(name: String): List<com.gigcreator.domain.models.GuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByName(name)
    }

    override suspend fun searchAcousticGuitarByBrand(name: String): List<com.gigcreator.domain.models.GuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByBrand(name)
    }

    override suspend fun searchAcousticGuitarByPrice(name: String): List<com.gigcreator.domain.models.GuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByPrice(name)
    }

    override suspend fun searchAcousticGuitarByStrings(name: Int): List<com.gigcreator.domain.models.GuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByStrings(name)
    }
}