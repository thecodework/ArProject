package com.example.arproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arproject.databinding.RowCategoryBinding
import com.example.arproject.model.ModelCategory

class CategoryAdapter(private val context: Context?, private val arraylist: ArrayList<ModelCategory>) :
    RecyclerView.Adapter<CategoryAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding =
            RowCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        if (context != null) {
            with(holder) {
             //   binding.tvItem.text = arraylist[position].categoryname
             //   binding.imageItem.setImageResource(arraylist[position].categoryimage)
            }
        }
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class MyHolder(val binding: RowCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}