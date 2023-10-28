package com.gigcreator.data.storage

import android.content.Context
import com.gigcreator.domain.models.UserData

private const val SHARED_NAME = "shared_name"
private const val ID = "shared_id"
private const val EMAIL = "shared_email"
private const val PASSWORD = "shared_password"

private const val DEFAULT_ID = ""
private const val DEFAULT_EMAIL = ""
private const val DEFAULT_PASSWORD = ""

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    override fun save(userData: UserData) {
        sharedPreferences.edit().putString(ID, userData.id).apply()
        sharedPreferences.edit().putString(EMAIL, userData.email).apply()
        sharedPreferences.edit().putString(PASSWORD, userData.password).apply()
    }

    override fun get(): UserData {
        val id = sharedPreferences.getString(ID, DEFAULT_ID)?: DEFAULT_ID
        val email = sharedPreferences.getString(EMAIL, DEFAULT_EMAIL)?: DEFAULT_EMAIL
        val password = sharedPreferences.getString(PASSWORD, DEFAULT_PASSWORD)?: DEFAULT_PASSWORD
        return UserData(id, email, password)
    }

}