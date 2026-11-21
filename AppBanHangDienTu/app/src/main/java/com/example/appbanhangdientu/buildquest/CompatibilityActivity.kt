package com.example.appbanhangdientu.buildquest

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.appbanhangdientu.R

class CompatibilityActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compatibility)

        val txtTotal = findViewById<TextView>(
            R.id.txtCompatibilityTotal
        )

        txtTotal.text =
            "Tổng giá: ${BuildDemoData.formatPrice(
                BuildDemoData.totalPrice()
            )}"

        findViewById<Button>(R.id.btnAddBuildToCart)
            .setOnClickListener {
                Toast.makeText(
                    this,
                    "Demo: Đã chọn thêm cấu hình vào giỏ hàng",
                    Toast.LENGTH_LONG
                ).show()
            }

        findViewById<Button>(R.id.btnBackCompatibility)
            .setOnClickListener {
                finish()
            }
    }
}
