package com.wizyta.aplikacja.helpers

import com.google.gson.annotations.SerializedName

data class LoginRegisterRequest(
    @SerializedName("login")
    val username: String,
    @SerializedName("password")
    val password: String
)