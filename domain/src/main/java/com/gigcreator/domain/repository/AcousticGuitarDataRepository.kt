package com.gigcreator.domain.repository

import com.gigcreator.domain.models.AcousticGuitarData
import retrofit2.http.GET
import retrofit2.http.Query

interface AcousticGuitarDataRepository {
    @GET("/guitar/acoustic")
    suspend fun readAcousticGuitar(): List<AcousticGuitarData>

    @GET("/guitar/acoustic/search/name?")
    suspend fun searchAcousticGuitarByName(@Query("name") name: String): List<AcousticGuitarData>

    @GET("/guitar/acoustic/search/brand?")
    suspend fun searchAcousticGuitarByBrand(@Query("name") name: String): List<AcousticGuitarData>

    @GET("/guitar/acoustic/search/price?")
    suspend fun searchAcousticGuitarByPrice(@Query("name") name: String): List<AcousticGuitarData>

    @GET("/guitar/acoustic/search/strings?")
    suspend fun searchAcousticGuitarByStrings(@Query("name") name: Int): List<AcousticGuitarData>
}