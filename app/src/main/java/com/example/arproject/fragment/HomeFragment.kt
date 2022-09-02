package com.example.arproject.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.arproject.ui.DemoData
import com.example.arproject.ui.DetailsActivity
import com.example.arproject.R
import com.example.arproject.adapter.CategoryAdapter
import com.example.arproject.adapter.ProductAdapter
import com.example.arproject.databinding.FragmentHomeBinding
import com.example.arproject.model.ModelCategory


class HomeFragment : Fragment(), ProductAdapter.ItemClick {
    lateinit var binding: FragmentHomeBinding
    var demoProductList: ArrayList<ModelCategory> = DemoData.getProductList(6)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home, container, false
        )
        initializer()
        return binding.root
    }

    private fun initializer() {
        binding.rvCategory.adapter = CategoryAdapter(demoProductList)
        binding.rvProducts.adapter = ProductAdapter(demoProductList, this)
    }

     override fun onClick(position: Int) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("USER_KEY", demoProductList[position])
        startActivity(intent)
    }
}