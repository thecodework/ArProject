package com.example.arproject.model

import java.io.Serializable

data class ModelCategory(
    val categoryimage: Int,
    val categoryname: String,
    val rating: Float = 4.5f,
    val price: Int = 470,
    val details: String="this is demo model"
):Serializable
