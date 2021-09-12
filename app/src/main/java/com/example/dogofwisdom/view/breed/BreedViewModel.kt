package com.example.dogofwisdom.view.breed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dogofwisdom.R
import com.example.dogofwisdom.model.entities.Breed
import com.example.dogofwisdom.model.service.DogsService
import com.example.dogofwisdom.view.BaseActivity
import com.example.dogofwisdom.view.BaseViewModel
import com.example.dogofwisdom.view.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BreedViewModel
@Inject constructor(
	private val dogsService: DogsService
) : BaseViewModel() {
	
	private val _imagesLD = MutableLiveData<List<String>>()
	val imagesLD = _imagesLD as LiveData<List<String>>
	
	fun getImages(breed: Breed) {
		safeCall {
			_imagesLD.postValue(dogsService.getRandomImages(breed))
			BaseActivity.SuccessNotification.postEvent(R.string.fetch_images_success)
		}
	}
}