package com.gigcreator.musicstore.presentation.fragment.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigcreator.domain.models.UserDataModel
import com.gigcreator.domain.usecase.UserStorageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userStorageUseCase: UserStorageUseCase): ViewModel() {

    private val _user = MutableLiveData<UserDataModel>()
    val user: LiveData<UserDataModel> = _user

    fun get(){
        _user.value = userStorageUseCase.get()
    }

    fun save(userDataModel: UserDataModel){
        userStorageUseCase.save(userDataModel)
    }
}