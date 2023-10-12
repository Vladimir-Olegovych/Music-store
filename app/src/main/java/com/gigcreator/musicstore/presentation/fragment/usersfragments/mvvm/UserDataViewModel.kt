package com.gigcreator.musicstore.presentation.fragment.usersfragments.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gigcreator.domain.models.Result
import com.gigcreator.domain.models.UserData
import com.gigcreator.domain.usecase.UserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDataViewModel @Inject constructor(private val userDataUseCase: UserDataUseCase): ViewModel() {

    private val _resultRead = MutableLiveData<List<UserData>>()
    val resultRead: LiveData<List<UserData>> = _resultRead

    private val _resultSearch = MutableLiveData<UserData>()
    val resultSearch: LiveData<UserData> = _resultSearch

    private val _resultSave = MutableLiveData<Result>()
    val resultSave: LiveData<Result> = _resultSave


    fun readUser(key: String){
        viewModelScope.launch(Dispatchers.IO){
            _resultRead.postValue(userDataUseCase.readUser(key))
        }
    }

    fun searchUser(email: String, key: String){
        viewModelScope.launch(Dispatchers.IO){
            _resultSearch.postValue(userDataUseCase.searchUser(email, key))
        }
    }
    fun saveUser(email: String, password: String, key: String){
        viewModelScope.launch(Dispatchers.IO){
            _resultSave.postValue(userDataUseCase.saveUser(email, password, key))
        }
    }
}