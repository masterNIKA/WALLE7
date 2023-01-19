package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CardAdded : AppCompatActivity() {

    private lateinit var addAnotherCard: TextView
    private lateinit var gotoMainPage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_added)

        addAnotherCard = findViewById(R.id.Card_Added_Add_Another)
        gotoMainPage = findViewById(R.id.Card_Added_Go_To_Main_Page)

        addAnotherCard.setOnClickListener {
            startActivity(Intent(this,AddCard::class.java))
        }

        gotoMainPage.setOnClickListener {
            startActivity(Intent(this,MainPage::class.java))
        }
    }
}