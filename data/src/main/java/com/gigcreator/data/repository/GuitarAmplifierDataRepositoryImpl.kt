package com.gigcreator.data.repository

import com.gigcreator.data.guitars.GuitarAmplifierData
import com.gigcreator.domain.models.GuitarAmplifier
import com.gigcreator.domain.repository.GuitarAmplifierDataRepository

class GuitarAmplifierDataRepositoryImpl(private val guitarAmplifierData: GuitarAmplifierData): GuitarAmplifierDataRepository {
    override suspend fun readAmplifier(): List<GuitarAmplifier> {
        return guitarAmplifierData.readAmplifier()
    }

    override suspend fun searchAmplifierByName(name: String): List<GuitarAmplifier> {
        return guitarAmplifierData.searchAmplifierByName(name)
    }

    override suspend fun searchAmplifierByBrand(name: String): List<GuitarAmplifier> {
        return guitarAmplifierData.searchAmplifierByBrand(name)
    }

    override suspend fun searchAmplifierByPrice(name: String): List<GuitarAmplifier> {
        return guitarAmplifierData.searchAmplifierByPrice(name)
    }
}