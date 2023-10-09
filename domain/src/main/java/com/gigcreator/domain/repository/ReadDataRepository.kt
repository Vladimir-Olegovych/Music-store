package com.gigcreator.domain.repository

import com.gigcreator.domain.models.BaseModel
import retrofit2.http.GET

interface ReadDataRepository {
    @GET("postgres")
    suspend fun readData(): BaseModel
}