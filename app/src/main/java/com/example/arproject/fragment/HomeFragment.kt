package com.example.arproject.fragment

import com.example.arproject.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.arproject.DemoData
import com.example.arproject.adapter.CategoryAdapter
import com.example.arproject.adapter.ProductAdapter
import com.example.arproject.databinding.FragmentHomeBinding
import com.example.arproject.model.ModelCategory


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home, container, false
        )
        initializer()
        setListener()
        return binding.root
    }

    private fun setListener() {

    }

    private fun initializer() {
        binding.rvCategory.adapter = CategoryAdapter(DemoData.getProductList())
        binding.rvProducts.adapter = ProductAdapter(DemoData.getProductList())
    }
}