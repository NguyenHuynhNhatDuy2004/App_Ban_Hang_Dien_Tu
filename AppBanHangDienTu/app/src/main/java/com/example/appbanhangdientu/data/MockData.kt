package com.example.appbanhangdientu.data

import com.example.appbanhangdientu.R
import com.example.appbanhangdientu.model.CartItem
import com.example.appbanhangdientu.model.Category
import com.example.appbanhangdientu.model.Product

object MockData {
    val categories = listOf(
        Category(1, "Tất cả"),
        Category(2, "Điện thoại"),
        Category(3, "Laptop"),
        Category(4, "Tai nghe"),
        Category(5, "Đồng hồ"),
        Category(6, "Phụ kiện")
    )

    val products = listOf(
        Product(
            id = 1,
            title = "iPhone 16 Pro Max 256GB",
            description = "Điện thoại flagship cao cấp nhất từ Apple với chip A18 Pro mạnh mẽ, camera 48MP Zoom 5x, khung Titanium siêu bền.",
            price = 34990000.0,
            oldPrice = 36990000.0,
            rating = 4.9f,
            reviewCount = 250,
            imageResId = R.drawable.intro_logo,
            category = "Điện thoại",
            specifications = mapOf(
                "Màn hình" to "6.9 inch OLED Super Retina XDR 120Hz",
                "Chipset" to "Apple A18 Pro 3nm",
                "RAM" to "8 GB",
                "Bộ nhớ trong" to "256 GB",
                "Pin" to "4.685 mAh, sạc nhanh 30W"
            )
        ),
        Product(
            id = 2,
            title = "MacBook Pro 14 M3 Pro",
            description = "Laptop chuyên nghiệp hiệu năng vượt trội dành cho lập trình viên và nhà thiết kế đồ họa. Màn hình Liquid Retina XDR sống động.",
            price = 49990000.0,
            oldPrice = 52990000.0,
            rating = 4.8f,
            reviewCount = 180,
            imageResId = R.drawable.intro_logo,
            category = "Laptop",
            specifications = mapOf(
                "Màn hình" to "14.2 inch Liquid Retina XDR",
                "CPU" to "Apple M3 Pro (11-core CPU, 14-core GPU)",
                "RAM" to "18 GB",
                "SSD" to "512 GB",
                "Trọng lượng" to "1.61 kg"
            )
        ),
        Product(
            id = 3,
            title = "Sony WH-1000XM5 Noise Canceling",
            description = "Tai nghe chụp tai chống ồn hàng đầu thế giới với âm thanh Hi-Res chân thực, thời lượng pin lên tới 30 giờ.",
            price = 7990000.0,
            oldPrice = 8990000.0,
            rating = 4.7f,
            reviewCount = 310,
            imageResId = R.drawable.intro_logo,
            category = "Tai nghe",
            specifications = mapOf(
                "Thời lượng pin" to "30 giờ (bật ANC)",
                "Chống ồn" to "Processor V1 + QN1",
                "Kết nối" to "Bluetooth 5.2, 3.5mm",
                "Trọng lượng" to "250g"
            )
        ),
        Product(
            id = 4,
            title = "Apple Watch Series 10 Titanium",
            description = "Đồng hồ thông minh thế hệ mới nhất với màn hình lớn hơn 30%, mỏng nhẹ thời trang, đo điện tâm đồ và cảnh báo ngưng thở khi ngủ.",
            price = 19990000.0,
            oldPrice = 21990000.0,
            rating = 4.9f,
            reviewCount = 95,
            imageResId = R.drawable.intro_logo,
            category = "Đồng hồ",
            specifications = mapOf(
                "Màn hình" to "OLED LTPO3 Always-On 2000 nits",
                "Khung vỏ" to "Titanium đánh bóng",
                "Chống nước" to "50m (WR50)",
                "Pin" to "Lên tới 36 giờ ở chế độ tiết kiệm"
            )
        )
    )

    val sampleCartItems = mutableListOf(
        CartItem(products[0], quantity = 1),
        CartItem(products[2], quantity = 2)
    )
}
