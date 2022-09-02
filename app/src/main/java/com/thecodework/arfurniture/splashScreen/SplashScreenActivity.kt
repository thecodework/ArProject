package com.thecodework.arfurniture.splashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.thecodework.arfurniture.R
import com.thecodework.arfurniture.databinding.ActivitySplashscreenBinding
import com.thecodework.arfurniture.utils.Utils.Companion.hideStatusBar

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splashscreen)
        hideStatusBar(binding.tvfurnish)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, OnBoardingScreen1::class.java)
            startActivity(intent)
        }, 3000)
    }
}