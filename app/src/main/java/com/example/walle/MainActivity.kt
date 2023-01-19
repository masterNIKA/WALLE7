package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password : EditText
    private lateinit var signUp: TextView
    private lateinit var forgotPassword: TextView
    private lateinit var loginButton: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.Log_Pg_Email)
        password = findViewById(R.id.Log_Pg_Pass)
        signUp = findViewById(R.id.Log_Pg_Sign_Up)
        forgotPassword = findViewById(R.id.Log_Pg_Forgot_Password)
        loginButton = findViewById(R.id.Log_Pg_Log_In_Button)
        auth = Firebase.auth

        signUp.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }

        forgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPassword::class.java))
        }

        loginButton.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this,"Email is empty",Toast.LENGTH_SHORT).show()
            }

            if (password.isEmpty()){
                Toast.makeText(this,"Password is empty",Toast.LENGTH_SHORT).show()
            }

            if (email.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this,"Login successful",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,MainPage::class.java))
                    }else{
                        Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}