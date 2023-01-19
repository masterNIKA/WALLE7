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

class NewPassword : AppCompatActivity() {

    private lateinit var oldPassword: EditText
    private lateinit var newPassword: EditText
    private lateinit var continueButton: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        oldPassword = findViewById(R.id.New_Password_Old_Password)
        newPassword = findViewById(R.id.New_Password_New_Password)
        continueButton = findViewById(R.id.New_Password_Continue_Button)
        auth = Firebase.auth

        continueButton.setOnClickListener {
            val oldPassword = oldPassword.text.toString()
            val newPassword = newPassword.text.toString()

            if (newPassword==oldPassword){
                Toast.makeText(this, "Try another password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (newPassword.isEmpty()){
                Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.currentUser?.updatePassword(newPassword)?.addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "Your password changed", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this,"Something's wrong",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}