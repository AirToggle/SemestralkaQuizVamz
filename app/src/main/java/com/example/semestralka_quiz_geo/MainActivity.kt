package com.example.semestralka_quiz_geo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main) // ktoré ekno sa pouzíva
        val buttonSpusti: Button = findViewById(R.id.button) // spojazdnenie buttonu
        val buttonZavri: Button = findViewById(R.id.button2)

        buttonSpusti.setOnClickListener {
            val intent = Intent(this, hl_menu::class.java)
            startActivity(intent)
        }

        buttonZavri.setOnClickListener {
            finishAffinity()
        }
    }
}

