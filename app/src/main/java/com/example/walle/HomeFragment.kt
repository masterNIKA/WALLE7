package com.example.walle

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var addCard: TextView
    private lateinit var pay: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addCard = view.findViewById(R.id.Fragment_Home_Add_Card)
        pay = view.findViewById(R.id.Fragment_Home_Pay)

        addCard.setOnClickListener {
            startActivity(Intent(context,AddCard::class.java))
        }

        pay.setOnClickListener {
            startActivity(Intent(context,PaymentPage::class.java))
        }

    }

}