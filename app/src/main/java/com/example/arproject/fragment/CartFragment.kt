package com.example.arproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.arproject.DemoData
import com.example.arproject.R
import com.example.arproject.adapter.CartAdapter
import com.example.arproject.adapter.ShopAdapter
import com.example.arproject.databinding.FragmentCartBinding
import com.example.arproject.model.ModelCategory


class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding
    var demoProductList: ArrayList<ModelCategory> = DemoData.getProductList(2)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        initializer()
        return binding.root
    }

    private fun initializer() {
        binding.rvShop.adapter = CartAdapter(demoProductList)
    }
}