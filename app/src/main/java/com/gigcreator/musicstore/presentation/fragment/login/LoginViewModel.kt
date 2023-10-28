package com.gigcreator.musicstore.presentation.fragment.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gigcreator.domain.models.UserData
import com.gigcreator.domain.usecase.UserDataUseCase
import com.gigcreator.domain.usecase.UserStorageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userDataUseCase: UserDataUseCase,
    private val userStorageUseCase: UserStorageUseCase
): ViewModel() {

    private val _resultSearch = MutableLiveData<UserData>()
    val resultSearch: LiveData<UserData> = _resultSearch

    fun searchUser(email: String, key: String){
        viewModelScope.launch(Dispatchers.IO){
            _resultSearch.postValue(userDataUseCase.searchUser(email, key))
        }
    }
    //sp
    fun save(userData: UserData){
        userStorageUseCase.save(userData)
    }
}