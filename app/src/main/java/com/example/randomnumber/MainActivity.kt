package com.example.randomnumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        username = findViewById(R.id.etUsername)
        val generateBtn = findViewById<Button>(R.id.btnGenerate)
        generateBtn.setOnClickListener {
            goToNumber()
        }

    }

    private fun goToNumber() {
        if (username.text.isNotEmpty()) {
            val i = Intent(this, RandomNumActivity::class.java)
            i.putExtra("username", username.text.toString())
            Toast.makeText(this, username.text.toString(), Toast.LENGTH_SHORT).show()
            startActivity(i)
        }else{
            username.requestFocus()
        }
    }
}