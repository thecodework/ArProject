package debsin.thecodework.arfurniture.splashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import debsin.thecodework.arfurniture.R
import debsin.thecodework.arfurniture.databinding.ActivitySplashscreenBinding
import debsin.thecodework.arfurniture.utils.Utils.Companion.hideStatusBar

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splashscreen)
        hideStatusBar(binding.tvfurnish)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, OnBoardingScreen1::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}