package com.gigcreator.musicstore.presentation.fragment.guitar.acousticguitar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gigcreator.domain.models.GuitarData
import com.gigcreator.domain.usecase.AcousticGuitarDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AcousticGuitarViewModel @Inject constructor(private val acousticGuitarDataUseCase: AcousticGuitarDataUseCase): ViewModel() {

    private val _resultGuitarData = MutableLiveData<List<GuitarData>>()
    val resultGuitarData: LiveData<List<GuitarData>> = _resultGuitarData

    fun readAcousticGuitar(){
        viewModelScope.launch(Dispatchers.IO){
            _resultGuitarData.postValue(acousticGuitarDataUseCase.readAcousticGuitar())
        }
    }

    fun searchAcousticGuitarByName(name: String) {
        viewModelScope.launch(Dispatchers.IO){
            _resultGuitarData.postValue(acousticGuitarDataUseCase.searchAcousticGuitarByName(name))
        }
    }

    fun searchAcousticGuitarByBrand(name: String) {
        viewModelScope.launch(Dispatchers.IO){
            _resultGuitarData.postValue(acousticGuitarDataUseCase.searchAcousticGuitarByBrand(name))
        }
    }

    fun searchAcousticGuitarByPrice(name: String) {
        viewModelScope.launch(Dispatchers.IO){
            _resultGuitarData.postValue(acousticGuitarDataUseCase.searchAcousticGuitarByPrice(name))
        }
    }

    fun searchAcousticGuitarByStrings(name: Int) {
        viewModelScope.launch(Dispatchers.IO){
            _resultGuitarData.postValue(acousticGuitarDataUseCase.searchAcousticGuitarByStrings(name))
        }
    }
}