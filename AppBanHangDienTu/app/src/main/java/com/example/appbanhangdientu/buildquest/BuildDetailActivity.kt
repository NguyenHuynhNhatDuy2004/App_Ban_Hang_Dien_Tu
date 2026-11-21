
package com.example.appbanhangdientu.buildquest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appbanhangdientu.R

class BuildDetailActivity : Activity() {

    private lateinit var txtBuildName: TextView
    private lateinit var txtSelectedGPU: TextView
    private lateinit var txtBuildTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_detail)

        val type = intent.getIntExtra("BUILD_TYPE", 1)
        BuildDemoData.selectBuild(type)

        txtBuildName = findViewById(R.id.txtBuildName)
        txtSelectedGPU = findViewById(R.id.txtSelectedGPU)
        txtBuildTotal = findViewById(R.id.txtBuildTotal)

        findViewById<Button>(R.id.btnChangeGPU)
            .setOnClickListener {
                startActivity(
                    Intent(
                        this,
                        ChangeComponentActivity::class.java
                    )
                )
            }

        findViewById<Button>(R.id.btnCheckCompatibility)
            .setOnClickListener {
                startActivity(
                    Intent(
                        this,
                        CompatibilityActivity::class.java
                    )
                )
            }

        findViewById<Button>(R.id.btnBackDetail)
            .setOnClickListener {
                finish()
            }
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    private fun updateUI() {
        val data = BuildDemoData
        val type = data.buildType

        txtBuildName.text = data.names[type]
        txtSelectedGPU.text =
            "GPU - ${data.gpuNames[data.gpuIndex]}"

        txtBuildTotal.text =
            "Tổng cộng: ${data.formatPrice(data.totalPrice())}"

        val components = findViewById<android.widget.LinearLayout>(
            R.id.layoutComponents
        )

        val cpu = components.getChildAt(0) as TextView
        val mainboard = components.getChildAt(1) as TextView
        val ram = components.getChildAt(2) as TextView
        val ssd = components.getChildAt(5) as TextView
        val psu = components.getChildAt(6) as TextView

        cpu.text = "CPU - ${data.cpus[type]}"
        mainboard.text =
            "Mainboard - ${data.mainboards[type]}"
        ram.text = "RAM - ${data.rams[type]}"
        ssd.text = "SSD - ${data.ssds[type]}"
        psu.text = data.psus[type]
    }
}
