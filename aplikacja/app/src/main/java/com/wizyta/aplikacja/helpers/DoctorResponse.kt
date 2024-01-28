package com.wizyta.aplikacja.helpers

import com.google.gson.annotations.SerializedName

data class DoctorResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)