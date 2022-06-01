package com.example.arproject.model

import com.example.arproject.R
import java.io.Serializable

class UserModel : Serializable {
    var image: Int? = R.drawable.sofa
    var name: String? = null
    var price: Int? = 700
    var rating: Float? = 2.0f
}