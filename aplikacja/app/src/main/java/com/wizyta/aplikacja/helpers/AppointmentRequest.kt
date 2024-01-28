package com.wizyta.aplikacja.helpers


import com.google.gson.annotations.SerializedName

data class AppointmentRequest(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("doctorId")
    val doctorId: Int? = null
)