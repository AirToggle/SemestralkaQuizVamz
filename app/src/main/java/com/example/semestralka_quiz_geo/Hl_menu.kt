package com.example.semestralka_quiz_geo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.semestralka_quiz_geo.R

class hl_menu :AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.hl_menu) // ktoré ekno sa pouzíva
        val buttonSpusti: Button = findViewById(R.id.spusti_hru) // spojazdnenie buttonu
        val buttonEncyklopedia: Button = findViewById(R.id.encyklopedia)
        val buttonNastavenia: Button = findViewById(R.id.nastavenia)
        val buttonUkonci_hru: Button = findViewById(R.id.ukonci_hru)


        buttonSpusti.setOnClickListener {
            val intent = Intent(this, hl_menu::class.java)
            startActivity(intent)
            finishAffinity()
        }

        buttonEncyklopedia.setOnClickListener {
            val intent = Intent(this, hl_menu::class.java)
            startActivity(intent)
            finishAffinity()
        }

        buttonNastavenia.setOnClickListener {
            val intent = Intent(this, hl_menu::class.java)
            startActivity(intent)
            finishAffinity()
        }

        buttonUkonci_hru.setOnClickListener {
            finishAffinity()
        }
    }

}