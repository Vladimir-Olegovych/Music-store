package com.gigcreator.domain.repository

import com.gigcreator.domain.models.GuitarData
import retrofit2.http.GET
import retrofit2.http.Query

interface ElectricGuitarDataRepository {
    @GET("/guitar/electric")
    suspend fun readAcousticGuitar(): List<GuitarData>

    @GET("/guitar/electric/search/name?")
    suspend fun searchAcousticGuitarByName(@Query("name") name: String): List<GuitarData>

    @GET("/guitar/electric/search/brand?")
    suspend fun searchAcousticGuitarByBrand(@Query("name") name: String): List<GuitarData>

    @GET("/guitar/electric/search/price?")
    suspend fun searchAcousticGuitarByPrice(@Query("name") name: String): List<GuitarData>

    @GET("/guitar/electric/search/strings?")
    suspend fun searchAcousticGuitarByStrings(@Query("name") name: Int): List<GuitarData>
}