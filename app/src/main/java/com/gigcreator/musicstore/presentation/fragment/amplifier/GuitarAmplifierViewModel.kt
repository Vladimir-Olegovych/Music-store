package com.gigcreator.musicstore.presentation.fragment.amplifier

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gigcreator.domain.models.GuitarAmplifier
import com.gigcreator.domain.usecase.GuitarAmplifierDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class GuitarAmplifierViewModel @Inject constructor(private val guitarAmplifierDataUseCase: GuitarAmplifierDataUseCase): ViewModel() {

    private val _resultGuitarAmplifierData = MutableLiveData<List<GuitarAmplifier>>()
    val resultGuitarAmplifierData: LiveData<List<GuitarAmplifier>> = _resultGuitarAmplifierData


    fun readAmplifier() {
        viewModelScope.launch(Dispatchers.IO) {
            _resultGuitarAmplifierData.postValue(guitarAmplifierDataUseCase.readAmplifier())
        }
    }

    fun searchAmplifierByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _resultGuitarAmplifierData.postValue(guitarAmplifierDataUseCase.searchAmplifierByName(name))
        }
    }

    fun searchAmplifierByBrand(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _resultGuitarAmplifierData.postValue(guitarAmplifierDataUseCase.searchAmplifierByBrand(name))
        }
    }

    fun searchAmplifierByPrice(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _resultGuitarAmplifierData.postValue(guitarAmplifierDataUseCase.searchAmplifierByPrice(name))
        }
    }
}