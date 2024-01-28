package com.wizyta.aplikacja.data

import android.R
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.wizyta.aplikacja.backend.Retrofit
import com.wizyta.aplikacja.backend.ServerApi
import com.wizyta.aplikacja.data.model.LoggedInUser
import com.wizyta.aplikacja.helpers.DoctorResponse
import com.wizyta.aplikacja.helpers.LoginRegisterRequest
import kotlinx.android.synthetic.main.fragment_doctor.view.doctorSpinner
import kotlinx.android.synthetic.main.fragment_doctor.view.progressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication

            val serverApi = Retrofit.client?.create(ServerApi::class.java)
            var loginRegisterRequest = LoginRegisterRequest(username,password)
            val call = serverApi?.postLogin(loginRegisterRequest);
            var x = call?.execute();
            println(x?.message())
            println(call)
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            println(e)
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}