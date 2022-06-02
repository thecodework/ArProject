package com.example.arproject.SplashScreen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import com.example.arproject.R
import com.example.arproject.databinding.ActivityLoginBinding
import com.example.arproject.databinding.ActivitySplashscreenBinding

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splashscreen)
        hideStatusBar(binding.tvfurnish)
        Handler().postDelayed({
            val intent = Intent(this, OnBoardingScreen1::class.java)
            startActivity(intent)

        }, 7000) // 3000 is the delayed time in milliseconds.
    }

    private fun hideStatusBar(view: View) {
        if (Build.VERSION.SDK_INT >= 30) {
            Log.d("check", "if call")
            view.windowInsetsController?.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
        } else {
            view.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
    }
}