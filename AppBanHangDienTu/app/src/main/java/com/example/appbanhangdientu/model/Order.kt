package com.example.appbanhangdientu.model

data class Order(
    val id: String,
    val customerName: String,
    val customerPhone: String,
    val orderDate: String,
    val totalPrice: Double,
    var status: String,
    val itemCount: Int
)
