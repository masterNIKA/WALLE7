package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class PaymentPage : AppCompatActivity() {

    private lateinit var payButton: TextView
    private lateinit var goToMainPage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_page)

        payButton = findViewById(R.id.Payment_Page_Pay_Button)
        goToMainPage = findViewById(R.id.Payment_Page_Go_To_Main_Page)

        payButton.setOnClickListener {
            Toast.makeText(this, "Payment successful", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }

        goToMainPage.setOnClickListener {
            startActivity(Intent(this, MainPage::class.java))
        }
    }
}