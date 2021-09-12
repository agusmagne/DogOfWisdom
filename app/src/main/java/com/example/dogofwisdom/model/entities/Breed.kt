package com.example.dogofwisdom.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Breed(var displayName: String = "", var breed: String = "", var variant: String = "") : Parcelable