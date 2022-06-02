package com.example.arproject.splashScreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.LoginActivity
import com.example.arproject.R
import com.example.arproject.SignUpActivity
import com.example.arproject.databinding.OnboardingScreen1Binding
import com.example.arproject.utils.Utils

class OnBoardingScreen1 : AppCompatActivity() {
    lateinit var binding: OnboardingScreen1Binding

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.onboarding_screen1)
        Utils.hideStatusBar(binding.tvfurnish)
        val leftAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        val rightAnim = AnimationUtils.loadAnimation(this, R.anim.slide_out_right)
        binding.btnLogin.startAnimation(leftAnim)
        binding.btnSignUpOnBoarding1.startAnimation(rightAnim)
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUpOnBoarding1.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}