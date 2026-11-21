package com.example.appbanhangdientu.buildquest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.example.appbanhangdientu.R
import java.text.NumberFormat
import java.util.Locale

class BuildBudgetActivity : Activity() {

    private var budget = 20_000_000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_budget)

        val txtBudget = findViewById<TextView>(R.id.txtBudget)
        val seekBudget = findViewById<SeekBar>(R.id.seekBudget)
        val rgPriority = findViewById<RadioGroup>(R.id.rgPriority)

        val monitor = findViewById<CheckBox>(R.id.checkMonitor)
        val keyboard = findViewById<CheckBox>(R.id.checkKeyboard)
        val mouse = findViewById<CheckBox>(R.id.checkMouse)

        val formatter = NumberFormat.getNumberInstance(
            Locale("vi", "VN")
        )

        seekBudget.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    budget = (progress + 5) * 1_000_000L
                    txtBudget.text =
                        "${formatter.format(budget)} VNĐ"
                }

                override fun onStartTrackingTouch(
                    seekBar: SeekBar?
                ) {}

                override fun onStopTrackingTouch(
                    seekBar: SeekBar?
                ) {}
            }
        )

        findViewById<Button>(R.id.btnBackBudget)
            .setOnClickListener {
                finish()
            }

        findViewById<Button>(R.id.btnNextBudget)
            .setOnClickListener {

                val priority = when (rgPriority.checkedRadioButtonId) {
                    R.id.rbPerformance -> "PERFORMANCE"
                    R.id.rbSaving -> "SAVING"
                    else -> "BALANCED"
                }

                val devices = arrayListOf<String>()

                if (monitor.isChecked) devices.add("MONITOR")
                if (keyboard.isChecked) devices.add("KEYBOARD")
                if (mouse.isChecked) devices.add("MOUSE")

                val intent = Intent(
                    this,
                    BuildSuggestionActivity::class.java
                )

                intent.putExtra(
                    "PURPOSE",
                    this.intent.getStringExtra("PURPOSE") ?: "GENERAL"
                )
                intent.putExtra("BUDGET", budget)
                intent.putExtra("PRIORITY", priority)
                intent.putStringArrayListExtra("DEVICES", devices)

                startActivity(intent)
            }
    }
}
