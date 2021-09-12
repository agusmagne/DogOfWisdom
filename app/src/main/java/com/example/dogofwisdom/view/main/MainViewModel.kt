package com.example.dogofwisdom.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogofwisdom.model.entities.Breed
import com.example.dogofwisdom.model.service.DogsService
import com.example.dogofwisdom.view.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val dogsService: DogsService
) : BaseViewModel() {
    
    private val _breedsLD = MutableLiveData<List<Breed>>()
    val breedsLD = _breedsLD as LiveData<List<Breed>>

    fun getBreeds() {
        safeCall {
            _breedsLD.postValue(dogsService.getAllBreeds())
        }
    }

}