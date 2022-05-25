package com.example.arproject

import com.example.arproject.model.ModelCategory

class DemoData {

    companion object {
        fun getDemoModel(): ModelCategory {
            // return ModelCategory(R.drawable.sofa, "sofa",4,700,"Lorem ipsum dolor")
            return ModelCategory(R.drawable.sofa, "sofa")
        }
    }
}