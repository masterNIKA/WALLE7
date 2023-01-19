package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PaymentSuccessful : AppCompatActivity() {

    private lateinit var goToMainPage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_successful)

        goToMainPage = findViewById(R.id.Payment_Successful_Go_To_Main_Page)

        goToMainPage.setOnClickListener {
            startActivity(Intent(this,MainPage::class.java))
        }
    }
}