package com.example.trabalho_android_avancado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val myDatabase = MyDatabase(this)

        val Button1MainAc3 = findViewById<Button>(R.id.button1ACTM3)
        val Button2MainAct3=findViewById<Button>(R.id.button2ACTM3)
        val LOGIN =findViewById<EditText>(R.id.editText1ACTM3)
        val PASSWD = findViewById<EditText>(R.id.editText2ACTM3)
        val CPF = findViewById<EditText>(R.id.editText3ACTM3)
        val EMAIL = findViewById<EditText>(R.id.editText4ACTM3)

        Button1MainAc3.setOnClickListener {
            finish()
        }

        Button2MainAct3.setOnClickListener {

            myDatabase.insertLog(
                LOGIN.text.toString(),
                PASSWD.text.toString(),
                CPF.text.toString(),
                EMAIL.text.toString())

            finish()
        }


    }
}
