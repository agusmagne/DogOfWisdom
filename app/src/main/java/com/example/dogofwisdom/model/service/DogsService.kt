package com.example.dogofwisdom.model.service

import com.example.dogofwisdom.model.entities.Breed
import com.example.dogofwisdom.network.DogsApi
import com.example.dogofwisdom.utils.EntityMapper

class DogsService(private val dogsApi: DogsApi) {
	
	suspend fun getAllBreeds(): List<Breed> {
		val res = dogsApi.getAllBreeds()
		if (res.isSuccessful) {
			val breedsResponse = res.body() ?: throw Exception()
			return EntityMapper.buildDogBreeds(breedsResponse.breeds)
		}
		return listOf()
	}
	
}