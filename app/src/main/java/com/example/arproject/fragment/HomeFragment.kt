package com.example.arproject.fragment

import android.content.Intent
import com.example.arproject.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.arproject.DemoData
import com.example.arproject.DetailsActivity
import com.example.arproject.adapter.CategoryAdapter
import com.example.arproject.adapter.ProductAdapter
import com.example.arproject.adapter.ShopAdapter
import com.example.arproject.databinding.FragmentHomeBinding
import com.example.arproject.model.ModelCategory


class HomeFragment : Fragment(), ProductAdapter.ItemClick {
    lateinit var binding: FragmentHomeBinding
    var demoProductList: ArrayList<ModelCategory> = DemoData.getProductList()

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
        binding.rvCategory.adapter = CategoryAdapter(demoProductList)
        binding.rvProducts.adapter = ProductAdapter(demoProductList,this)
    }

    override fun onClick(position: Int) {
        val intent = Intent(context, DetailsActivity::class.java)
        val pic: Int = demoProductList[position].categoryimage
        intent.putExtra("image", pic)
        startActivity(intent)
    }
}