package com.example.dogofwisdom.utils

import com.example.dogofwisdom.model.entities.Breed

object EntityMapper {
	/**
	 * Example of dictionary entry:
	 *
	 * 	{
	 * 		bulldog: ["french", "whatever"],
	 * 		asd: [...],
	 * 		...
	 * 	}
	 *
	 */
	fun mapBreedsRawToBreedsList(breedsRaw: Map<String, List<String>>): List<Breed> {
		val breeds = mutableListOf<Breed>()
		breedsRaw.forEach { breedRaw ->
			if (breedRaw.value.isEmpty()) {
				val breed = Breed()
				breed.displayName = breedRaw.key.replaceFirstChar { char -> char.uppercase() }
				breed.breed = breedRaw.key
				breeds.add(breed)
			} else {
				breedRaw.value.forEach { variation ->
					val breed = Breed()
					val name = variation.replaceFirstChar { char -> char.uppercase() } + " " + breedRaw.key
					breed.displayName = name
					breed.breed = breedRaw.key
					breed.variant = variation
					breeds.add(breed)
				}
			}
		}
		return breeds
	}
}