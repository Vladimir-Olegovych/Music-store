package com.gigcreator.musicstore.presentation.fragment.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gigcreator.domain.models.BaseModel
import com.gigcreator.domain.usecase.ReadDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val readDataUseCase: ReadDataUseCase): ViewModel() {

    private val _resultLiveData = MutableLiveData<BaseModel>()
    val resultLiveData: LiveData<BaseModel> = _resultLiveData

    fun readData(){
        viewModelScope.launch(Dispatchers.IO){
            _resultLiveData.postValue(readDataUseCase.execute())
        }
    }
}