package com.gigcreator.musicstore.presentation.fragment.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gigcreator.domain.models.Result
import com.gigcreator.domain.usecase.UserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val userDataUseCase: UserDataUseCase, ): ViewModel() {

    private val _resultSave = MutableLiveData<Result>()
    val resultSave: LiveData<Result> = _resultSave

    fun saveUser(email: String, password: String, key: String){
        viewModelScope.launch(Dispatchers.IO){
            _resultSave.postValue(userDataUseCase.saveUser(email, password, key))
        }
    }
}