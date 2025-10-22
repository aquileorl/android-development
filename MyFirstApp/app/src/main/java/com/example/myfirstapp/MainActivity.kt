package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.textoPrincipal)
        val btn = findViewById<Button>(R.id.btnSaludar)

        btn.setOnClickListener {

            tv.text = "Bien hecho!"
        }
    }
}