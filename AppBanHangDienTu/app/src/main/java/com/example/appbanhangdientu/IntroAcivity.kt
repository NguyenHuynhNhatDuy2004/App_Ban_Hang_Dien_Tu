package com.example.appbanhangdientu

import android.content.Intent
import android.os.Bundle
import com.example.appbanhangdientu.databinding.ActivityIntroBinding

class IntroAcivity : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.signInTxt.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
