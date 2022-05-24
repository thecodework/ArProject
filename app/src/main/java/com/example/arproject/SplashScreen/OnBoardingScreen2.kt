package com.example.arproject.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.R
import com.example.arproject.SignUpActivity
import com.example.arproject.databinding.ActivityLoginBinding
import com.example.arproject.databinding.OnboardingScreen1Binding
import com.example.arproject.databinding.OnboardingScreen2Binding

class OnBoardingScreen2 : AppCompatActivity(){

    lateinit var binding: OnboardingScreen2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.onboarding_screen2)

       binding.btnSignUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }

}