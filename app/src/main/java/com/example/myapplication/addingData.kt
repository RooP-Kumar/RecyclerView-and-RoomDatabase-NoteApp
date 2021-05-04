package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.DataFile.Data
import com.example.myapplication.Database.DataViewModel

class addingData : AppCompatActivity() {
    lateinit var dataViewModel: DataViewModel
    lateinit var texttotake: EditText
    lateinit var saveBtn: Button
    lateinit var description: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_data)
        val intent = intent
        var i = intent.getIntExtra("Rvalue", 1)
        dataViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
            .get(DataViewModel::class.java)
        texttotake = findViewById(R.id.textforsaving)
        description = findViewById(R.id.description)
        saveBtn = findViewById(R.id.savebtn)

        saveBtn.setOnClickListener{
            val name = texttotake.text.toString()
            val description = description.text.toString()
            if (name != null && description != null)
            {
                val data = Data(i, name, description)
                dataViewModel.add_Data(data)
                finish()
            }
        }
    }
}

