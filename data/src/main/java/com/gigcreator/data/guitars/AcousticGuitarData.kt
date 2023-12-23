package com.gigcreator.data.guitars

import com.gigcreator.domain.models.GuitarData
import retrofit2.http.GET
import retrofit2.http.Query

interface AcousticGuitarData {
    @GET("/guitar/acoustic")
    suspend fun readAcousticGuitar(): List<GuitarData>

    @GET("/guitar/acoustic/search/name?")
    suspend fun searchAcousticGuitarByName(@Query("name") name: String): List<GuitarData>

    @GET("/guitar/acoustic/search/brand?")
    suspend fun searchAcousticGuitarByBrand(@Query("name") name: String): List<GuitarData>

    @GET("/guitar/acoustic/search/price?")
    suspend fun searchAcousticGuitarByPrice(@Query("name") name: String): List<GuitarData>

    @GET("/guitar/acoustic/search/strings?")
    suspend fun searchAcousticGuitarByStrings(@Query("name") name: Int): List<GuitarData>
}