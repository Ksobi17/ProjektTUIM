package com.wizyta.aplikacja.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wizyta.aplikacja.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        const val url : String = "http://172.24.240.1:8080/";
    }

}