package com.example.appbanhangdientu

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.appbanhangdientu.data.AdminMockData
import com.example.appbanhangdientu.data.MockData
import com.example.appbanhangdientu.databinding.ActivityCheckoutBinding
import com.example.appbanhangdientu.model.Order
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CheckoutActivity : BaseActivity() {
    private lateinit var binding: ActivityCheckoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDefaultInfo()
        calculateTotal()
        setupListeners()
    }

    private fun setupDefaultInfo() {
        binding.nameEdt.setText("Nguyễn Văn A")
        binding.phoneEdt.setText("0901234567")
        binding.addressEdt.setText("123 Nguyễn Trãi, Quận 1, TP. Hồ Chí Minh")
    }

    private fun calculateTotal() {
        val cartItems = MockData.sampleCartItems
        val subtotal = cartItems.sumOf { it.product.price * it.quantity }
        val shipping = if (cartItems.isEmpty()) 0.0 else 30000.0
        val total = subtotal + shipping

        val formatter = NumberFormat.getCurrencyInstance(Locale.Builder().setLanguage("vi").setRegion("VN").build())
        binding.subtotalTxt.text = formatter.format(subtotal)
        binding.shippingTxt.text = formatter.format(shipping)
        binding.totalTxt.text = formatter.format(total)
        binding.barTotalTxt.text = formatter.format(total)
    }

    private fun setupListeners() {
        binding.backBtn.setOnClickListener { finish() }

        binding.confirmOrderBtn.setOnClickListener {
            val name = binding.nameEdt.text.toString().trim()
            val phone = binding.phoneEdt.text.toString().trim()
            val address = binding.addressEdt.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin nhận hàng!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedPaymentMethod = when (binding.paymentRadioGroup.checkedRadioButtonId) {
                R.id.radioMomo -> "Ví MoMo"
                R.id.radioBanking -> "Chuyển khoản Ngân hàng (QR)"
                R.id.radioZaloPay -> "Ví ZaloPay / Thẻ ATM"
                else -> "Thanh toán khi nhận hàng (COD)"
            }

            // Create new order & save to Mock Data for Admin Order Management
            val orderId = "DH${(1005..9999).random()}"
            val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
            val cartItems = MockData.sampleCartItems
            val total = cartItems.sumOf { it.product.price * it.quantity } + 30000.0

            AdminMockData.orders.add(
                0,
                Order(
                    id = orderId,
                    customerName = name,
                    customerPhone = phone,
                    orderDate = currentDate,
                    totalPrice = total,
                    status = "Chờ xử lý",
                    itemCount = cartItems.sumOf { it.quantity }
                )
            )

            // Show Order Success Dialog
            AlertDialog.Builder(this)
                .setTitle("🎉 Đặt Hàng Thành Công!")
                .setMessage("Mã đơn hàng: $orderId\nNgười nhận: $name\nSố điện thoại: $phone\nĐịa chỉ: $address\nPhương thức: $selectedPaymentMethod\n\nCảm ơn bạn đã mua sắm tại Tech Store!")
                .setPositiveButton("Về Trang Chủ") { _, _ ->
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                    finish()
                }
                .setCancelable(false)
                .show()
        }
    }
}
