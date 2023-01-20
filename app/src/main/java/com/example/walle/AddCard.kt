package com.example.walle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AddCard : AppCompatActivity() {

    private lateinit var fullName: EditText
    private lateinit var cardNumber: EditText
    private lateinit var cvc: EditText
    private lateinit var validThru: EditText
    private lateinit var userAddress: EditText
    private lateinit var cardName: EditText
    private lateinit var addButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        fullName = findViewById(R.id.Add_Card_Full_Name)
        cardNumber = findViewById(R.id.Add_Card_Card_Number)
        cvc = findViewById(R.id.Add_Card_CVC)
        validThru = findViewById(R.id.Add_Card_Valid_Thru)
        userAddress = findViewById(R.id.Add_Card_City)
        cardName = findViewById(R.id.Add_Card_Card_Name)
        addButton = findViewById(R.id.Add_Card_Add_Button)

        addButton.setOnClickListener {
            val fullName = fullName.text.toString()
            val cardNumber = cardNumber.text.toString()
            val cvc = cvc.text.toString()
            val validThru = validThru.text.toString()
            val userAddress = userAddress.text.toString()
            val cardName = cardName.text.toString()

            if (fullName.isEmpty()||cardNumber.isEmpty()||cvc.isEmpty()||validThru.isEmpty()||userAddress.isEmpty()||cardName.isEmpty()){
                Toast.makeText(this, "Fill all the fields",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (cardNumber.length != 16) {
                Toast.makeText(this, "Card number should be 16 digits", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (cvc.length != 3) {
                Toast.makeText(this, "CVC should be 3 digits", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }
}