package com.example.appbanhangdientu

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.appbanhangdientu.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val email = binding.emailEdt.text.toString().lowercase().trim()

            if (email.contains("admin")) {
                Toast.makeText(this, "Đăng nhập quyền Admin thành công!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AdminDashboardActivity::class.java))
            } else {
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            }
            finish()
        }

        binding.adminLoginBtn.setOnClickListener {
            Toast.makeText(this, "Đăng nhập trang quản trị Admin", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AdminDashboardActivity::class.java))
            finish()
        }

        binding.registerTxt.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
