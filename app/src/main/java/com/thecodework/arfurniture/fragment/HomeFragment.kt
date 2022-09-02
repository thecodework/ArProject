package com.thecodework.arfurniture.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.thecodework.arfurniture.ui.DemoData
import com.thecodework.arfurniture.ui.DetailsActivity
import com.thecodework.arfurniture.R
import com.thecodework.arfurniture.adapter.CategoryAdapter
import com.thecodework.arfurniture.adapter.ProductAdapter
import com.thecodework.arfurniture.databinding.FragmentHomeBinding
import com.thecodework.arfurniture.model.ModelCategory


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