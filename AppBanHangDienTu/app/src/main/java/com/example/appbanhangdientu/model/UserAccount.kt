package com.example.appbanhangdientu.model

data class UserAccount(
    val id: Int,
    val name: String,
    val email: String,
    val role: String,
    var isLocked: Boolean = false
)
