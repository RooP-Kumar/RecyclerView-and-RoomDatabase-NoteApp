package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class showingDescription : AppCompatActivity() {
    lateinit var showName: TextView
    lateinit var showDes: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showing_description)
        val intent = intent
        val name = intent.getStringExtra("Rname")
        val des = intent.getStringExtra("Rdes")
        showName = findViewById(R.id.showing_name)
        showDes = findViewById(R.id.showing_des)
        showName.text = name
        showDes.text = des
    }
}