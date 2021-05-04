package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databaseFiles.UserViewModel
import com.example.myapplication.databaseFiles.Word

class MainActivity2 : AppCompatActivity() {
    lateinit var msg: String
    lateinit var btn: Button
    lateinit var text: EditText
    lateinit var userviewmodel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        userviewmodel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        btn = findViewById(R.id.saveId)
        text = findViewById(R.id.textforsaving)

        btn.setOnClickListener {
            msg = text.text.toString()
            if(msg.isNotEmpty()) {
                userviewmodel.add_Data(Word(msg))
                finish()
            }
        }

    }
}