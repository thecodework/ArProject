package com.example.arproject.fragment

import com.example.arproject.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.arproject.adapter.CategoryAdapter
import com.example.arproject.adapter.ProductAdapter
import com.example.arproject.databinding.FragmentHomeBinding
import com.example.arproject.model.ModelCategory


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var arraylist: ArrayList<ModelCategory> = ArrayList()
    var productlist: ArrayList<ModelCategory> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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
        arraylist.add(ModelCategory(R.drawable.sofa, "Sofa"))
        arraylist.add(ModelCategory(R.drawable.bed, "Bed"))
        arraylist.add(ModelCategory(R.drawable.sofa, "Sofa"))
        arraylist.add(ModelCategory(R.drawable.bed, "Bed"))
        arraylist.add(ModelCategory(R.drawable.sofa, "Sofa"))
        arraylist.add(ModelCategory(R.drawable.bed, "Bed"))
        productlist.add(ModelCategory(R.drawable.yellowsofa, "Sofa"))
        productlist.add(ModelCategory(R.drawable.table, "table"))
        productlist.add(ModelCategory(R.drawable.yellowsofa, "Sofa"))
        productlist.add(ModelCategory(R.drawable.table, "table"))
        productlist.add(ModelCategory(R.drawable.yellowsofa, "Sofa"))
        productlist.add(ModelCategory(R.drawable.table, "table"))
        binding.rvCategory.adapter = CategoryAdapter(context, arraylist)
        binding.rvProducts.adapter = ProductAdapter(context, productlist)
    }
}