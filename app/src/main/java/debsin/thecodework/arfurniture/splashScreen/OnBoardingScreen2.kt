package debsin.thecodework.arfurniture.splashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import debsin.thecodework.arfurniture.R
import debsin.thecodework.arfurniture.ui.SignUpActivity
import debsin.thecodework.arfurniture.databinding.OnboardingScreen2Binding
import debsin.thecodework.arfurniture.utils.Utils

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