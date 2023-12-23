package com.gigcreator.musicstore.presentation.fragment.shopitem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigcreator.domain.models.GuitarAmplifier

class GuitarAmplifierItemViewModel: ViewModel() {
    private val _resultGuitarAmplifierData = MutableLiveData<GuitarAmplifier>()
    val resultGuitarAmplifierData: LiveData<GuitarAmplifier> = _resultGuitarAmplifierData

    fun setGuitarAmplifierData(guitarAmplifier: GuitarAmplifier){
        _resultGuitarAmplifierData.value = guitarAmplifier
    }
}