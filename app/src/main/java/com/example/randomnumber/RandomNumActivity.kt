package com.example.randomnumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class RandomNumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_random_num)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val tvNumb = findViewById<TextView>(R.id.tvNumb)
        val btnShare = findViewById<Button>(R.id.btnShare)

        tvWelcome.text = "${getUsername()}, your lucky number is: "
        tvNumb.text = getRandomNumb().toString()
        btnShare.setOnClickListener {
            onShare(getUsername(),getRandomNumb())
        }
    }

    private fun getUsername(): String {
        val intent = intent
        val username = intent.getStringExtra("username").toString()
        return username
    }

    private fun getRandomNumb(): Int {
        return Random.nextInt(1000)
    }

    private fun onShare(username: String, numb: Int) {
        val i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "name: $username")
        i.putExtra(Intent.EXTRA_TEXT, "Lucky Number: $numb")
        startActivity(i)
    }
}