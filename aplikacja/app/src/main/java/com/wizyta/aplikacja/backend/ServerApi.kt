package com.wizyta.aplikacja.backend

import com.wizyta.aplikacja.helpers.AppointmentResponse
import com.wizyta.aplikacja.helpers.DoctorResponse
import com.wizyta.aplikacja.helpers.AppointmentRequest
import com.wizyta.aplikacja.helpers.LoginRegisterRequest
import com.wizyta.aplikacja.helpers.Msg
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServerApi {

    @GET("/appointment")
    fun getAppointment(): Call<List<AppointmentResponse>>

    @POST("/appointment")
    fun postAppointment(@Body appointmentRequest: AppointmentRequest): Call<List<AppointmentResponse>>

    @POST("/login")
    fun postLogin(@Body loginRegisterRequest: LoginRegisterRequest): Call<Msg>

    @POST("/register")
    fun postRegister(@Body loginRegisterRequest: LoginRegisterRequest): Call<Msg>

    @GET("/doctor")
    fun getDoctors(): Call<List<DoctorResponse>>
}