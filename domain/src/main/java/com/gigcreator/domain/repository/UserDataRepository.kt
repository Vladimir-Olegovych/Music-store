package com.gigcreator.domain.repository

import com.gigcreator.domain.models.Result
import com.gigcreator.domain.models.UserData
import retrofit2.http.GET
import retrofit2.http.Query

interface UserDataRepository {
    @GET("read?")
    suspend fun readUser(@Query("key") key: String): List<UserData>

    @GET("search?&")
    suspend fun searchUser(@Query("email") email: String,
                           @Query("key") key: String): UserData

    @GET("save?&&")
    suspend fun saveUser(@Query("email") email: String,
                         @Query("password") password: String,
                         @Query("key") key: String): Result
}