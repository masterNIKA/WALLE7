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

class SignUp : AppCompatActivity() {

    private lateinit var fullName: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var mobileNumber: EditText
    private lateinit var signUpButton: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        fullName = findViewById(R.id.Sign_Up_Full_Name)
        email = findViewById(R.id.Sign_Up_Email)
        password = findViewById(R.id.Sign_Up_Password)
        mobileNumber = findViewById(R.id.Sign_Up_Phone_Number)
        signUpButton = findViewById(R.id.Sign_Up_Sign_Up)
        auth = Firebase.auth

        signUpButton.setOnClickListener {
            val fullName = fullName.text.toString()
            val email = email.text.toString()
            val password = password.text.toString()
            val mobileNumber = mobileNumber.text.toString()

            if (fullName.isEmpty()){
                Toast.makeText(this,"Name is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email.isEmpty()){
                Toast.makeText(this,"email is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (mobileNumber.isEmpty()){
                Toast.makeText(this,"Number is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                Toast.makeText(this,"password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (email.isNotEmpty() && password.isNotEmpty() && fullName.isNotEmpty() && mobileNumber.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    Toast.makeText(this, "You have signed up", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MainActivity::class.java))
                }
            }
        }
    }
}