package com.example.arproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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
        pDialog = ProgressDialog(this)
    }
    
    private fun setListener() {
        binding.imgGoogle.setOnClickListener{
            pDialog!!.showProgressDialog()
            Handler().postDelayed({
                val intent = Intent(this, DashboardActivity::class.java)
                pDialog!!.hideProgressDialog()
                startActivity(intent)
            }, 1000) // 3000 is the delayed time in milliseconds.
        }
        binding.imgFacebook.setOnClickListener{
            pDialog!!.showProgressDialog()
            Handler().postDelayed({
                val intent = Intent(this, DashboardActivity::class.java)
                pDialog!!.hideProgressDialog()
                startActivity(intent)
            }, 1000) // 3000 is the delayed time in milliseconds.
        }
        binding.btnLoginActivity.setOnClickListener {
            pDialog!!.showProgressDialog()
            val password = binding.edPassword.text.toString().trim()
            val email = binding.edEmail.text.toString().trim()
            if (password.isNotEmpty() && email.isNotEmpty()) {
                if (isValidEmail(email)) {
                    if (isValidPassword(password)) {
                        if (password.length > 6) {

                            Handler().postDelayed({
                                val intent = Intent(this, DashboardActivity::class.java)
                                pDialog!!.hideProgressDialog()
                                startActivity(intent)
                            }, 3000) // 3000 is the delayed time in milliseconds.
                        } else {
                            showDialog(this, "Password should be greater than 6 digit")
                            pDialog!!.hideProgressDialog()
                        }
                    } else {
                        showDialog(
                            this,
                            "Password should be contain one capital letter,one symbol & one number")
                        pDialog!!.hideProgressDialog()
                    }
                } else {
                    showDialog(this, "Enter valid emailId")
                    pDialog!!.hideProgressDialog()
                }
            } else {
                showDialog(this, "Enter valid Email & Password")
                pDialog!!.hideProgressDialog()
            }
        }
    }

    private fun initializer() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}