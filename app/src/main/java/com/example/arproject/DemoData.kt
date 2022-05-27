package com.example.arproject

import com.example.arproject.model.ModelCategory
import kotlin.random.Random

class DemoData {
    companion object {
        fun getProductList(): ArrayList<ModelCategory> {
            return arrayListOf(
                getDemoModel(), getDemoModel(), getDemoModel(),
                getDemoModel(), getDemoModel(), getDemoModel()
            )
        }

        private fun getDemoModel(): ModelCategory {
            val randomValue = Random.nextInt(1, 5)
            return ModelCategory(
                getProductImage(randomValue),
                getProductName(randomValue),
                Random.nextDouble(0.0, 5.0).toFloat(),
                Random.nextInt(5000, 25000),
                getProductDescription()
            )
        }

        private fun getProductImage(pic: Int): Int {
            val productImageMap: Map<Int, Int> = mapOf(
                1 to R.drawable.whitesofa,
                2 to R.drawable.bedproduct,
                3 to R.drawable.table,
                4 to R.drawable.yellowsofa,
                5 to R.drawable.blacksofa
            )
            return productImageMap.getValue(pic)
        }

        private fun getProductName(name: Int): String {
            val productName =
                mapOf(1 to "Sofa", 2 to "Bed", 3 to "Table", 4 to "Sofa", 5 to "Sofa")
            return productName.getValue(name)
        }

        private fun getProductDescription(): String = "This is a piece of an Art"
    }
}