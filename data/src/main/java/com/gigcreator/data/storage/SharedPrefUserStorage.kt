package com.gigcreator.data.storage

import android.content.Context
import com.gigcreator.domain.models.UserDataModel

private const val SHARED_NAME = "shared_name"
private const val ID = "shared_id"
private const val EMAIL = "shared_email"
private const val PASSWORD = "shared_password"

private const val DEFAULT_ID = ""
private const val DEFAULT_EMAIL = ""
private const val DEFAULT_PASSWORD = ""

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    override fun save(userDataModel: UserDataModel) {
        sharedPreferences.edit().putString(ID, userDataModel.id).apply()
        sharedPreferences.edit().putString(EMAIL, userDataModel.email).apply()
        sharedPreferences.edit().putString(PASSWORD, userDataModel.password).apply()
    }

    override fun get(): UserDataModel {
        val id = sharedPreferences.getString(ID, DEFAULT_ID)?: DEFAULT_ID
        val email = sharedPreferences.getString(EMAIL, DEFAULT_EMAIL)?: DEFAULT_EMAIL
        val password = sharedPreferences.getString(PASSWORD, DEFAULT_PASSWORD)?: DEFAULT_PASSWORD
        return UserDataModel(id, email, password)
    }

}