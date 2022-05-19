package com.example.arproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arproject.R
import com.example.arproject.databinding.ActivityDashboardBinding.inflate
import com.example.arproject.databinding.RowCategoryBinding
import com.example.arproject.model.ModelCategory

class CategoryAdapter(private val context: Context?, private val arraylist: ArrayList<ModelCategory>) :
    RecyclerView.Adapter<CategoryAdapter.myholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myholder {
        val binding =
            RowCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myholder(binding)
    }

    override fun onBindViewHolder(holder: myholder, position: Int) {
        if (context != null) {
            with(holder) {
                binding.tvItem.text = arraylist[position].categoryname
                binding.imageItem.setImageResource(arraylist[position].categoryimage)
            }
        }
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class myholder(val binding: RowCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}