package com.example.dogofwisdom.model.service

import com.example.dogofwisdom.model.entities.Breed
import com.example.dogofwisdom.network.DogsApi
import com.example.dogofwisdom.utils.EntityMapper

class DogsService(private val dogsApi: DogsApi) {
	
	/**
	 * Gets raw response of all breeds from server and maps it to a list of breeds
	 */
	suspend fun getAllBreeds(): List<Breed> {
		val res = dogsApi.getAllBreeds()
		if (res.isSuccessful) {
			val breedsResponse = res.body() ?: throw Exception()
			return EntityMapper.mapBreedsRawToBreedsList(breedsResponse.breeds)
		}
		return listOf()
	}
	
	/**
	 * Gets 10 images of the same breed
	 * No fix is applied for getting the same repeated image
	 * This issue should be fixed in the back-end, most likely I'd create a different endpoint
	 */
	suspend fun getRandomImages(breed: Breed): List<String> {
		val images = mutableListOf<String>()
		for (i in 1..10) {
			val res = if (breed.variant == "") {
				dogsApi.getRandomImage(breed.breed)
			} else {
				dogsApi.getRandomImageVariant(breed.breed, breed.variant)
			}
			if (res.isSuccessful) {
				val getRandomImageResponse = res.body()!!
				images.add(getRandomImageResponse.imageUrl)
			}
		}
		return images
	}
	
}