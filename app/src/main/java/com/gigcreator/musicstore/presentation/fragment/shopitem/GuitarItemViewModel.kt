package com.gigcreator.musicstore.presentation.fragment.shopitem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gigcreator.domain.models.GuitarData

class GuitarItemViewModel: ViewModel() {

    private val _resultAcousticGuitarData = MutableLiveData<GuitarData>()
    val resultAcousticGuitarData: LiveData<GuitarData> = _resultAcousticGuitarData

    private val _resultElectricGuitarData = MutableLiveData<GuitarData>()
    val resultElectricGuitarData: LiveData<GuitarData> = _resultElectricGuitarData

    fun setElectricGuitarData(guitarData: GuitarData){
        _resultElectricGuitarData.value = guitarData
    }

    fun setAcousticGuitarData(guitarData: GuitarData){
        _resultAcousticGuitarData.value = guitarData
    }
}