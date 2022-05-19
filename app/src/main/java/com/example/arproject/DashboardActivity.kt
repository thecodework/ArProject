package com.example.arproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.arproject.databinding.ActivityDashboardBinding

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
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment())
            .commit()
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