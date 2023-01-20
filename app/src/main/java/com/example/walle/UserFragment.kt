package com.example.walle

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class UserFragment : Fragment(R.layout.fragment_user) {

    private lateinit var changePassword: TextView
    private lateinit var logOut: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changePassword = view.findViewById(R.id.Main_Page_Fragment_User_Change_Password)
        logOut = view.findViewById(R.id.Main_Page_Fragment_User_Log_Out)

        changePassword.setOnClickListener {
            startActivity(Intent(context,NewPassword::class.java))
        }

        logOut.setOnClickListener {
            startActivity(Intent(context,MainActivity::class.java))
        }

    }

}