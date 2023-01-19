package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPassword : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var sendButton: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        email = findViewById(R.id.Forgot_Pass_Email)
        sendButton = findViewById(R.id.Forgot_Password_Send_Button)
        auth = Firebase.auth

        sendButton.setOnClickListener {
            val email = email.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "Check your email", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,NewPassword::class.java))
                }else{
                    Toast.makeText(this,"Something's wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}