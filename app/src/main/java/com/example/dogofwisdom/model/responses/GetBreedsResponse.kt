package com.example.dogofwisdom.model.responses

import com.google.gson.annotations.SerializedName

class GetBreedsResponse(
    @SerializedName("message") val breeds: Map<String, List<String>> = mapOf(),
    val status: String = "error"
)