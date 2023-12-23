package com.gigcreator.data.repository

import com.gigcreator.data.guitars.ElectricGuitarData
import com.gigcreator.domain.repository.ElectricGuitarDataRepository


class ElectricGuitarDataRepositoryImpl(private val electricGuitarData: ElectricGuitarData): ElectricGuitarDataRepository {
    override suspend fun readAcousticGuitar(): List<com.gigcreator.domain.models.GuitarData> {
        return electricGuitarData.readAcousticGuitar()
    }

    override suspend fun searchAcousticGuitarByName(name: String): List<com.gigcreator.domain.models.GuitarData> {
        return electricGuitarData.searchAcousticGuitarByName(name)
    }

    override suspend fun searchAcousticGuitarByBrand(name: String): List<com.gigcreator.domain.models.GuitarData> {
        return electricGuitarData.searchAcousticGuitarByBrand(name)
    }

    override suspend fun searchAcousticGuitarByPrice(name: String): List<com.gigcreator.domain.models.GuitarData> {
        return electricGuitarData.searchAcousticGuitarByPrice(name)
    }

    override suspend fun searchAcousticGuitarByStrings(name: Int): List<com.gigcreator.domain.models.GuitarData> {
        return electricGuitarData.searchAcousticGuitarByStrings(name)
    }
}