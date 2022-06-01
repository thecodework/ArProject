package com.example.arproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivityDetailsBinding
import com.example.arproject.model.UserModel
import com.example.arproject.utils.Utils


class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        initializer()
        setListener()
    }

    private fun setListener() {
        binding.btnAR.setOnClickListener {
            val intent = Intent(this, ViewARModelActivity::class.java)
            startActivity(intent)
        }
        binding.imageBack.setOnClickListener {
            finish()
        }
        binding.tvCart.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("value", "1")
            startActivity(intent)
        }
    }

    private fun initializer() {
        Utils.changeStatusBar(this, R.color.white_new)
        val intent = intent
        val user: UserModel = intent.getSerializableExtra("USER_KEY") as UserModel
        binding.imageItem.setImageResource(user.image!!)
        binding.tvItem.text = user.name
        binding.rBar.rating = user.rating!!
        binding.tvPrice.text = user.price!!.toString()
    }
}