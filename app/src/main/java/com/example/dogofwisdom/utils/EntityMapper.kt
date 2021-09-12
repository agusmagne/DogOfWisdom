package com.example.dogofwisdom.utils

import com.example.dogofwisdom.model.entities.Breed

object EntityMapper {
	
	fun buildDogBreeds(breedsRaw: Map<String, List<String>>): List<Breed> {
		val breeds = mutableListOf<Breed>()
		breedsRaw.forEach { breedRaw ->
			if (breedRaw.value.isEmpty()) {
				val breed = Breed()
				breed.name = breedRaw.key.replaceFirstChar { char -> char.uppercase() }
				breeds.add(breed)
			} else {
				breedRaw.value.forEach {
					val breed = Breed()
					val name = it.replaceFirstChar { char -> char.uppercase() } + " " + breedRaw.key
					breed.name = name
					breeds.add(breed)
				}
			}
		}
		return breeds
	}
}