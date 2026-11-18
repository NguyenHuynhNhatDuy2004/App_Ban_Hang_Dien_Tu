package com.example.appbanhangdientu

import android.os.Bundle
import com.example.appbanhangdientu.data.AdminMockData
import com.example.appbanhangdientu.databinding.ActivityAdminRevenueBinding
import java.text.NumberFormat
import java.util.Locale

class AdminRevenueActivity : BaseActivity() {
    private lateinit var binding: ActivityAdminRevenueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminRevenueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener { finish() }

        val formatter = NumberFormat.getCurrencyInstance(Locale.Builder().setLanguage("vi").setRegion("VN").build())
        val revenue = AdminMockData.getTotalRevenue()
        val count = AdminMockData.getTotalOrdersCount()

        binding.totalRevenueTxt.text = formatter.format(revenue)
        binding.totalOrdersTxt.text = "$count Đơn"
    }
}
