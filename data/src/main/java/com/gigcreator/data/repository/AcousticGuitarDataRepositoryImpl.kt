package com.gigcreator.data.repository

import com.gigcreator.domain.models.AcousticGuitarData
import com.gigcreator.domain.repository.AcousticGuitarDataRepository

class AcousticGuitarDataRepositoryImpl(private val acousticGuitarDataRepository: AcousticGuitarDataRepository): AcousticGuitarDataRepository {
    override suspend fun readAcousticGuitar(): List<AcousticGuitarData> {
        return acousticGuitarDataRepository.readAcousticGuitar()
    }

    override suspend fun searchAcousticGuitarByName(name: String): List<AcousticGuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByName(name)
    }

    override suspend fun searchAcousticGuitarByBrand(name: String): List<AcousticGuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByBrand(name)
    }

    override suspend fun searchAcousticGuitarByPrice(name: String): List<AcousticGuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByPrice(name)
    }

    override suspend fun searchAcousticGuitarByStrings(name: Int): List<AcousticGuitarData> {
        return acousticGuitarDataRepository.searchAcousticGuitarByStrings(name)
    }

}