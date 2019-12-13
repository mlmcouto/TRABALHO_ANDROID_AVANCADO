package com.example.trabalho_android_avancado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Button1MainAc2 = findViewById<Button>(R.id.button1ACTM2)
        val Button2MainAc2=findViewById<Button>(R.id.button2ACTM2)

        Button1MainAc2.setOnClickListener {
            finish()
        }

        Button2MainAc2.setOnClickListener {
            val intent = Intent (this, MainActivity4::class.java)
            startActivity(intent)
        }


    }
}
