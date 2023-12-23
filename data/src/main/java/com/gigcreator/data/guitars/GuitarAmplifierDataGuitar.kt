package com.gigcreator.data.guitars

import com.gigcreator.domain.models.GuitarAmplifier
import com.gigcreator.domain.repository.GuitarAmplifierDataRepository

class GuitarAmplifierDataGuitar(private val amplifierDataRepository: GuitarAmplifierDataRepository): GuitarAmplifierData {
    override suspend fun readAmplifier(): List<GuitarAmplifier> {
        return amplifierDataRepository.readAmplifier()
    }

    override suspend fun searchAmplifierByName(name: String): List<GuitarAmplifier> {
        return amplifierDataRepository.searchAmplifierByName(name)
    }

    override suspend fun searchAmplifierByBrand(name: String): List<GuitarAmplifier> {
        return amplifierDataRepository.searchAmplifierByBrand(name)
    }

    override suspend fun searchAmplifierByPrice(name: String): List<GuitarAmplifier> {
        return amplifierDataRepository.searchAmplifierByPrice(name)
    }
}