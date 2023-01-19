package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainPage : AppCompatActivity() {

    private lateinit var addCard: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        addCard = findViewById(R.id.Main_Page_Add_Card)

        addCard.setOnClickListener {
            startActivity(Intent(this,AddCard::class.java))
        }
    }
}