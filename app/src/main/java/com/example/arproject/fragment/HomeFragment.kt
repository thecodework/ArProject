package com.example.arproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arproject.R
import com.example.arproject.adapter.CategoryAdapter
import com.example.arproject.databinding.FragmentHomeBinding
import com.example.arproject.model.ModelCategory

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var arraylist: ArrayList<ModelCategory> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
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
        binding.rvCategory.adapter=CategoryAdapter(context,arraylist)
    }
}