package com.thecodework.arfurniture.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.thecodework.arfurniture.R
import com.thecodework.arfurniture.databinding.ActivityDashboardBinding
import com.thecodework.arfurniture.fragment.CartFragment
import com.thecodework.arfurniture.fragment.HomeFragment
import com.thecodework.arfurniture.fragment.ProfileFragment
import com.thecodework.arfurniture.fragment.ShopFragment

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializer()
        setListener()
    }

    private fun initializer() {
        val number: String? = intent.getStringExtra("value")
        if (number?.equals("1") == true) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, CartFragment())
                .commit()
            binding.bottomNav.selectedItemId = R.id.menuCart
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment())
                .commit()
        }
        window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar_color)
    }

    private fun setListener() {
        binding.bottomNav.setOnItemSelectedListener {
            var f: Fragment? = null
            when (it.itemId) {
                R.id.menuHome -> f = HomeFragment()
                R.id.menuShop -> f = ShopFragment()
                R.id.menuCart -> f = CartFragment()
                R.id.menuProfile -> f = ProfileFragment()
            }
            if (f != null) {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, f).commit()
            }
            true
        }
    }
}