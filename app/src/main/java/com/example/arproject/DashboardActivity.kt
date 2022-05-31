package com.example.arproject

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.arproject.databinding.ActivityDashboardBinding
import com.example.arproject.fragment.CartFragment
import com.example.arproject.fragment.HomeFragment
import com.example.arproject.fragment.ProfileFragment
import com.example.arproject.fragment.ShopFragment
import com.example.arproject.utils.Utils

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
        if (number != null) {
            if (number.equals(1))
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, CartFragment())
                    .commit()
            binding.bottomNav.selectedItemId = R.id.menuCart
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment())
                .commit()
        }
        Utils.changeStatusBar(this, R.color.statusbar_color)
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