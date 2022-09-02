package com.thecodework.arfurniture.splashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.thecodework.arfurniture.R
import com.thecodework.arfurniture.ui.SignUpActivity
import com.thecodework.arfurniture.databinding.OnboardingScreen2Binding
import com.thecodework.arfurniture.utils.Utils

class OnBoardingScreen2 : AppCompatActivity() {

    lateinit var binding: OnboardingScreen2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.onboarding_screen2)
        Utils.hideStatusBar(binding.tvfurnish)
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}