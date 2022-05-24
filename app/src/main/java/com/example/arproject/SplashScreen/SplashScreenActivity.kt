package com.example.arproject.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.R
import com.example.arproject.databinding.ActivityLoginBinding
import com.example.arproject.databinding.ActivitySplashscreenBinding

class SplashScreenActivity: AppCompatActivity() {

    lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_splashscreen)

        Handler().postDelayed({
            val intent = Intent(this, OnBoardingScreen1::class.java)
            startActivity(intent)

        }, 3000) // 3000 is the delayed time in milliseconds.
    }
}