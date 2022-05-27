package com.example.arproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.SplashScreen.OnBoardingScreen1
import com.example.arproject.utils.Utils.Companion.isValidEmail
import com.example.arproject.utils.Utils.Companion.isValidPassword
import com.example.arproject.utils.Utils.Companion.showDialog
import com.example.arproject.databinding.ActivityLoginBinding
import com.example.arproject.utils.ProgressDialog

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private var pDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        initializer()
        setListener()
    }
     fun showProgressDialog() {
        if (pDialog == null){
            pDialog = ProgressDialog(this)
        }
        pDialog!!.showProgressDialog()
    }

     fun hideProgressDialog() {
        if (pDialog != null)
            pDialog!!.hideProgressDialog()
    }

    private fun setListener() {
        binding.btnLoginActivity.setOnClickListener {
            showProgressDialog()
            val password = binding.edPassword.text.toString().trim()
            val email = binding.edEmail.text.toString().trim()
            if (password.isNotEmpty() && email.isNotEmpty()) {
                if (isValidEmail(email)) {
                    if (isValidPassword(password)) {
                        if (password.length > 6) {

                            Handler().postDelayed({
                                val intent = Intent(this, DashboardActivity::class.java)
                                hideProgressDialog()
                                startActivity(intent)
                            }, 3000) // 3000 is the delayed time in milliseconds.

//                            val intent = Intent(this, DashboardActivity::class.java)
//                            startActivity(intent)
//                            showDialog(this, "Login Successfully")

                        } else {
                            showDialog(this, "Password should be greater than 6 digit")
                        }
                    } else {
                        showDialog(
                            this,
                            "Password should be contain one capital letter,one symbol & one number"
                        )
                    }
                } else {
                    showDialog(this, "Enter valid emailId")
                }
            } else {
                showDialog(this, "Enter valid Email & Password")
            }
        }
    }

    private fun initializer() {

    }
}