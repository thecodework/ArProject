package debsin.thecodework.arfurniture.splashScreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import debsin.thecodework.arfurniture.ui.LoginActivity
import debsin.thecodework.arfurniture.R
import debsin.thecodework.arfurniture.ui.SignUpActivity
import debsin.thecodework.arfurniture.databinding.OnboardingScreen1Binding
import debsin.thecodework.arfurniture.utils.Utils

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