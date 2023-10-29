package com.gigcreator.musicstore.presentation.fragment.acousticguitar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gigcreator.domain.models.AcousticGuitarData
import com.gigcreator.domain.usecase.AcousticGuitarDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AcousticGuitarViewModel @Inject constructor(private val acousticGuitarDataUseCase: AcousticGuitarDataUseCase): ViewModel() {

    private val _resultAcousticGuitarData = MutableLiveData<List<AcousticGuitarData>>()
    val resultAcousticGuitarData: LiveData<List<AcousticGuitarData>> = _resultAcousticGuitarData


    fun readAcousticGuitar(){
        viewModelScope.launch(Dispatchers.IO){
            _resultAcousticGuitarData.postValue(acousticGuitarDataUseCase.readAcousticGuitar())
        }
    }

    fun searchAcousticGuitarByName(name: String) {
        viewModelScope.launch(Dispatchers.IO){
            _resultAcousticGuitarData.postValue(acousticGuitarDataUseCase.searchAcousticGuitarByName(name))
        }
    }

    fun searchAcousticGuitarByBrand(name: String) {
        viewModelScope.launch(Dispatchers.IO){
            _resultAcousticGuitarData.postValue(acousticGuitarDataUseCase.searchAcousticGuitarByBrand(name))
        }
    }

    fun searchAcousticGuitarByPrice(name: String) {
        viewModelScope.launch(Dispatchers.IO){
            _resultAcousticGuitarData.postValue(acousticGuitarDataUseCase.searchAcousticGuitarByPrice(name))
        }
    }

    fun searchAcousticGuitarByStrings(name: Int) {
        viewModelScope.launch(Dispatchers.IO){
            _resultAcousticGuitarData.postValue(acousticGuitarDataUseCase.searchAcousticGuitarByStrings(name))
        }
    }
}