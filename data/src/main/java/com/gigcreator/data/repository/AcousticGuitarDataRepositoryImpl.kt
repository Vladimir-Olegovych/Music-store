package com.gigcreator.data.repository

import com.gigcreator.data.guitars.AcousticGuitarData
import com.gigcreator.domain.repository.AcousticGuitarDataRepository

class AcousticGuitarDataRepositoryImpl(private val acousticGuitarData: AcousticGuitarData): AcousticGuitarDataRepository {
    override suspend fun readAcousticGuitar(): List<com.gigcreator.domain.models.AcousticGuitarData> {
        return acousticGuitarData.readAcousticGuitar()
    }

    override suspend fun searchAcousticGuitarByName(name: String): List<com.gigcreator.domain.models.AcousticGuitarData> {
        return acousticGuitarData.searchAcousticGuitarByName(name)
    }

    override suspend fun searchAcousticGuitarByBrand(name: String): List<com.gigcreator.domain.models.AcousticGuitarData> {
        return acousticGuitarData.searchAcousticGuitarByBrand(name)
    }

    override suspend fun searchAcousticGuitarByPrice(name: String): List<com.gigcreator.domain.models.AcousticGuitarData> {
        return acousticGuitarData.searchAcousticGuitarByPrice(name)
    }

    override suspend fun searchAcousticGuitarByStrings(name: Int): List<com.gigcreator.domain.models.AcousticGuitarData> {
        return acousticGuitarData.searchAcousticGuitarByStrings(name)
    }
}