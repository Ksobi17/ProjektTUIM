package com.wizyta.aplikacja.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.wizyta.aplikacja.R
import com.wizyta.aplikacja.backend.Retrofit
import com.wizyta.aplikacja.backend.ServerApi
import com.wizyta.aplikacja.helpers.LoginRegisterRequest
import com.wizyta.aplikacja.helpers.Msg
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {

    private companion object {

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        prepareButton(root)
        return root
    }



    private fun prepareButton(root: View){
        val loginButton = root.findViewById<Button>(R.id.loginButton)
        val registerButton = root.findViewById<Button>(R.id.registerButton)
        val username = root.findViewById<EditText>(R.id.username)
        val password = root.findViewById<TextView>(R.id.password)
        val progressBar = root.findViewById<TextView>(R.id.progressBar)
        loginButton.setOnClickListener {

            if(username.text.toString().equals("")){Toast.makeText(context, "Wprowadź poprawną nazwę użytkownika!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            if(password.text.toString().equals("")){Toast.makeText(context, "Wprowadź poprawne hasło!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            val serverApi = Retrofit.client?.create(ServerApi::class.java)
            var loginRegisterRequest = LoginRegisterRequest(username.text.toString(),password.text.toString())
            progressBar?.visibility = View.VISIBLE
            val call = serverApi?.postLogin(loginRegisterRequest);
            call?.enqueue(object : Callback<Msg> {
                override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                    progressBar?.visibility = View.GONE
//                    println(response.body().msg)
                    if(response.body().msg.equals("badusername")){Toast.makeText(context, "Niepoprawna nazwa użytkownika", Toast.LENGTH_SHORT).show();return;}
                    if(response.body().msg.equals("badpassword")){Toast.makeText(context, "Niepoprawne hasło", Toast.LENGTH_SHORT).show();return;}
                    if(response.body().msg.equals("success")){Toast.makeText(context, "Zalogowano", Toast.LENGTH_SHORT).show();findNavController().navigate(R.id.action_fragmentLogin_to_fragmentDoctor2);return;}
                    Toast.makeText(context, response.body().msg, Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<Msg>, t: Throwable?) {
                    progressBar?.visibility = View.GONE
                    println(t)
                    Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show()
                }
            })

        }
        registerButton.setOnClickListener {

            if(username.text.toString().equals("")){Toast.makeText(context, "Wprowadź poprawną nazwę użytkownika!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            if(password.text.toString().equals("")){Toast.makeText(context, "Wprowadź poprawne hasło!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            val serverApi = Retrofit.client?.create(ServerApi::class.java)
            var loginRegisterRequest = LoginRegisterRequest(username.text.toString(),password.text.toString())
            progressBar?.visibility = View.VISIBLE
            val call = serverApi?.postRegister(loginRegisterRequest);
            call?.enqueue(object : Callback<Msg> {
                override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                    progressBar?.visibility = View.GONE
//                    println(response.body().msg)
                    if(response.body().msg.equals("takenusername")){Toast.makeText(context, "Zajęta nazwa użytkownika!", Toast.LENGTH_SHORT).show();return;}
                    if(response.body().msg.equals("success")){Toast.makeText(context, "zarejestrowano!", Toast.LENGTH_SHORT).show();return;}

                    Toast.makeText(context, response.body().msg, Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<Msg>, t: Throwable?) {
                    progressBar?.visibility = View.GONE
                    println(t)
                    Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show()
                }
            })

        }


    }
}