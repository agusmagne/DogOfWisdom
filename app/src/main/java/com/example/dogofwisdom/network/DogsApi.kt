package com.example.dogofwisdom.network

import com.example.dogofwisdom.model.responses.GetBreedsResponse
import com.example.dogofwisdom.model.responses.GetRandomImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsApi {
	
	companion object {
		private const val GET_BREEDS_URL = "breeds/list/all"
		private const val GET_RANDOM = "breed/{breed}/images/random"
		private const val GET_RANDOM_VARIANT = "breed/{breed}/{variant}/images/random"
	}
	
	@GET(GET_BREEDS_URL)
	suspend fun getAllBreeds(): Response<GetBreedsResponse>
	
	@GET(GET_RANDOM)
	suspend fun getRandomImage(
		@Path("breed") breed: String
	): Response<GetRandomImageResponse>
	
	@GET(GET_RANDOM_VARIANT)
	suspend fun getRandomImageVariant(
		@Path("breed") breed: String,
		@Path("variant") variant: String
	): Response<GetRandomImageResponse>
	
}