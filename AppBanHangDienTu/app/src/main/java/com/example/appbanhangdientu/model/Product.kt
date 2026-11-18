package com.example.appbanhangdientu.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val oldPrice: Double? = null,
    val rating: Float = 4.8f,
    val reviewCount: Int = 120,
    val imageResId: Int,
    val category: String,
    val specifications: Map<String, String> = emptyMap()
)
