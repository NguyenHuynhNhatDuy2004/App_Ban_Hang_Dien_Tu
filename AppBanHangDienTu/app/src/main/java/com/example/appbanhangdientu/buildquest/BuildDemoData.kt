package com.example.appbanhangdientu.buildquest

import java.text.NumberFormat
import java.util.Locale

object BuildDemoData {

    val names = listOf(
        "PC Học tập & Văn phòng",
        "PC Gaming Cân bằng",
        "PC Gaming & Đồ họa"
    )

    val cpus = listOf(
        "Intel Core i3-12100F",
        "Intel Core i5-12400F",
        "AMD Ryzen 7 7700"
    )

    val mainboards = listOf(
        "ASUS H610M",
        "ASUS B660M",
        "ASUS B650M"
    )

    val rams = listOf(
        "16GB DDR4",
        "16GB DDR4",
        "32GB DDR5"
    )

    val ssds = listOf(
        "SSD 512GB",
        "SSD NVMe 1TB",
        "SSD NVMe 1TB"
    )

    val psus = listOf(
        "PSU 500W",
        "PSU 650W",
        "PSU 750W"
    )

    val gpuNames = listOf(
        "GTX 1650 4GB",
        "RTX 4060 8GB",
        "RTX 4070 12GB"
    )

    val gpuPrices = listOf(
        3_500_000L,
        8_500_000L,
        15_000_000L
    )

    val basePrices = listOf(
        12_500_000L,
        20_500_000L,
        35_900_000L
    )

    var buildType = 1
    var gpuIndex = 1

    fun selectBuild(type: Int) {
        buildType = type.coerceIn(0, 2)
        gpuIndex = buildType
    }

    fun totalPrice(): Long {
        return basePrices[buildType] -
                gpuPrices[buildType] +
                gpuPrices[gpuIndex]
    }

    fun formatPrice(value: Long): String {
        val formatter = NumberFormat.getNumberInstance(
            Locale("vi", "VN")
        )
        return "${formatter.format(value)} VNĐ"
    }
}
