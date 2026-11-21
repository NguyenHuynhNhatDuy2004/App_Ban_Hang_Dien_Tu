
package com.example.appbanhangdientu.buildquest

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import com.example.appbanhangdientu.R

class ChangeComponentActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_component)

        val rgGPU = findViewById<RadioGroup>(R.id.rgGPU)

        val selectedId = when (BuildDemoData.gpuIndex) {
            0 -> R.id.rbGPU1
            1 -> R.id.rbGPU2
            else -> R.id.rbGPU3
        }

        rgGPU.check(selectedId)

        findViewById<Button>(R.id.btnConfirmComponent)
            .setOnClickListener {

                val index = when (rgGPU.checkedRadioButtonId) {
                    R.id.rbGPU1 -> 0
                    R.id.rbGPU2 -> 1
                    R.id.rbGPU3 -> 2
                    else -> 1
                }

                BuildDemoData.gpuIndex = index

                Toast.makeText(
                    this,
                    "Đã thay đổi card đồ họa",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }

        findViewById<Button>(R.id.btnBackComponent)
            .setOnClickListener {
                finish()
            }
    }
}
