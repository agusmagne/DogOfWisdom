package com.example.dogofwisdom.network

import com.example.dogofwisdom.model.responses.GetBreedsResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogsApi {

    companion object {
        private const val GET_BREEDS_URL = "breeds/list/all"
    }

    @GET(GET_BREEDS_URL)
    suspend fun getAllBreeds(): Response<GetBreedsResponse>

}