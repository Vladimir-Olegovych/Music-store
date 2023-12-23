package com.gigcreator.domain.repository

import com.gigcreator.domain.models.GuitarAmplifier
import retrofit2.http.GET
import retrofit2.http.Query

interface GuitarAmplifierDataRepository {
    @GET("/amplifier")
    suspend fun readAmplifier(): List<GuitarAmplifier>

    @GET("/amplifier/search/name?")
    suspend fun searchAmplifierByName(@Query("name") name: String): List<GuitarAmplifier>

    @GET("/amplifier/search/brand?")
    suspend fun searchAmplifierByBrand(@Query("name") name: String): List<GuitarAmplifier>

    @GET("/amplifier/search/price?")
    suspend fun searchAmplifierByPrice(@Query("name") name: String): List<GuitarAmplifier>
}