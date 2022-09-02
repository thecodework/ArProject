package com.thecodework.arfurniture.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.thecodework.arfurniture.ui.DemoData
import com.thecodework.arfurniture.R
import com.thecodework.arfurniture.adapter.CartAdapter
import com.thecodework.arfurniture.databinding.FragmentCartBinding
import com.thecodework.arfurniture.model.ModelCategory


class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding
    var demoProductList: ArrayList<ModelCategory> = DemoData.getProductList(2)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        initializer()
        return binding.root
    }

    private fun initializer() {
        binding.rvShop.adapter = CartAdapter(demoProductList)
    }
}