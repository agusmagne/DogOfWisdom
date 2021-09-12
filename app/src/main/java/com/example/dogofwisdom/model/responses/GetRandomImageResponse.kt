package com.example.dogofwisdom.model.responses

import com.google.gson.annotations.SerializedName

class GetRandomImageResponse(
	@SerializedName("message") val imageUrl: String = "",
	val status: String = "error"
)