package com.example.appbanhangdientu.data

import com.example.appbanhangdientu.model.Order
import com.example.appbanhangdientu.model.UserAccount

object AdminMockData {
    val orders = mutableListOf(
        Order("DH1001", "Nguyễn Văn A", "0901234567", "24/05/2026", 34990000.0, "Chờ xử lý", 1),
        Order("DH1002", "Trần Thị B", "0912345678", "23/05/2026", 49990000.0, "Đang giao", 1),
        Order("DH1003", "Lê Văn C", "0923456789", "22/05/2026", 15980000.0, "Đã hoàn thành", 2),
        Order("DH1004", "Phạm Minh D", "0934567890", "21/05/2026", 19990000.0, "Đã hoàn thành", 1)
    )

    val userAccounts = mutableListOf(
        UserAccount(1, "Nguyễn Văn A", "nguyenvana@gmail.com", "Khách hàng", false),
        UserAccount(2, "Trần Thị B", "tranthib@gmail.com", "Khách hàng", false),
        UserAccount(3, "Lê Văn C", "levanc@gmail.com", "Khách hàng", true),
        UserAccount(4, "Admin Quản Trị", "admin@techstore.vn", "Quản trị viên", false)
    )

    fun getTotalRevenue(): Double {
        return orders.filter { it.status == "Đã hoàn thành" || it.status == "Đang giao" }.sumOf { it.totalPrice }
    }

    fun getTotalOrdersCount(): Int {
        return orders.size
    }
}
