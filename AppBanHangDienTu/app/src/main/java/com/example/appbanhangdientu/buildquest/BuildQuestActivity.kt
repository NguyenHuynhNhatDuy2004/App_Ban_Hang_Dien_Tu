
package com.example.appbanhangdientu.buildquest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import com.example.appbanhangdientu.R

class BuildQuestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_quest)

        val rgPurpose = findViewById<RadioGroup>(R.id.rgPurpose)
        val btnStart = findViewById<Button>(R.id.btnStartBuild)

        btnStart.setOnClickListener {
            val purpose = when (rgPurpose.checkedRadioButtonId) {
                R.id.rbGaming -> "GAMING"
                R.id.rbDesign -> "DESIGN"
                R.id.rbOffice -> "OFFICE"
                R.id.rbGeneral -> "GENERAL"
                else -> null
            }

            if (purpose == null) {
                Toast.makeText(
                    this,
                    "Vui lòng chọn nhu cầu sử dụng",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val intent = Intent(
                this,
                BuildBudgetActivity::class.java
            )
            intent.putExtra("PURPOSE", purpose)
            startActivity(intent)
        }
    }
}
