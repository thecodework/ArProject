package com.example.arproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivitySignupBinding
import com.example.arproject.utils.ProgressDialog
import com.example.arproject.utils.Utils

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    private var pDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        initializer()
        setListener()
        pDialog = ProgressDialog(this)
    }

    private fun initializer() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    private fun setListener() {
        binding.btnCreateAccount.setOnClickListener {
            pDialog!!.showProgressDialog()
            val password = binding.edPassword.text.toString().trim()
            val email = binding.edEmail.text.toString().trim()
            val name = binding.edName.text.toString().trim()
            if (password.isNotEmpty() && email.isNotEmpty() && name.isNotEmpty()) {
                if (Utils.isValidEmail(email)) {
                    if (Utils.isValidPassword(password)) {
                        if (password.length > 6) {
                            Handler().postDelayed({
                                val intent = Intent(this, DashboardActivity::class.java)
                               pDialog!!.hideProgressDialog()
                                startActivity(intent)
                            }, 3000) // 3000 is the delayed time in milliseconds.
                        } else {
                            Utils.showDialog(this, "Password should be greater than 6 digit")
                            pDialog!!.hideProgressDialog()
                        }
                    } else {
                        Utils.showDialog(
                            this,
                            "Password should be contain one capital letter,one symbol & one number")
                        pDialog!!.hideProgressDialog()
                    }
                } else {
                    Utils.showDialog(this, "Enter valid emailId")
                    pDialog!!.hideProgressDialog()
                }
            } else {
                Utils.showDialog(this, "Enter valid Email & Password")
                pDialog!!.hideProgressDialog()
            }
        }
    }
}