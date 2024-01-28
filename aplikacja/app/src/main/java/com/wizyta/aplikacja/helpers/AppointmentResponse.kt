package com.wizyta.aplikacja.helpers


import com.google.gson.annotations.SerializedName

data class AppointmentResponse(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("doctor")
    val doctor: String? = null
)