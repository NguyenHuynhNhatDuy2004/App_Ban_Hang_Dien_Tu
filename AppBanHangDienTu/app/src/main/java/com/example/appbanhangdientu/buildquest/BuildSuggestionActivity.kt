package com.example.appbanhangdientu.buildquest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.appbanhangdientu.R

class BuildSuggestionActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_suggestion)

        findViewById<Button>(R.id.btnDetailBudget)
            .setOnClickListener {
                openDetail(0)
            }

        findViewById<Button>(R.id.btnDetailBalanced)
            .setOnClickListener {
                openDetail(1)
            }

        findViewById<Button>(R.id.btnDetailPerformance)
            .setOnClickListener {
                openDetail(2)
            }

        findViewById<Button>(R.id.btnBackSuggestion)
            .setOnClickListener {
                finish()
            }
    }

    private fun openDetail(buildType: Int) {
        val intent = Intent(
            this,
            BuildDetailActivity::class.java
        )
        intent.putExtra("BUILD_TYPE", buildType)
        startActivity(intent)
    }
}
