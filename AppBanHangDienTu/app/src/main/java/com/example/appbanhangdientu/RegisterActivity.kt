package com.example.appbanhangdientu

import android.os.Bundle
import com.example.appbanhangdientu.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            finish()
        }

        binding.loginTxt.setOnClickListener {
            finish()
        }
    }
}
