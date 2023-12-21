package com.gigcreator.data.user

import com.gigcreator.domain.models.Result
import com.gigcreator.domain.models.UserDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface UserData {
    @GET("/user?")
    suspend fun readUser(@Query("key") key: String): List<UserDataModel>

    @GET("/user/search?&")
    suspend fun searchUser(@Query("email") email: String,
                           @Query("key") key: String): UserDataModel

    @GET("/user/save?&&")
    suspend fun saveUser(@Query("email") email: String,
                         @Query("password") password: String,
                         @Query("key") key: String): Result
}