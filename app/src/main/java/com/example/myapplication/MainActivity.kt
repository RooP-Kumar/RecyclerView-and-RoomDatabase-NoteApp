package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DataFile.Data
import com.example.myapplication.Database.DataViewModel
import com.example.myapplication.RecyclerViewAdapter.MyAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var userViewModel: DataViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var addbtn: FloatingActionButton
    var i: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addbtn = findViewById(R.id.floatingActionButton)
        userViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(DataViewModel::class.java)
        recyclerView = findViewById(R.id.recycler_view)
        val adapter = MyAdapter(this, userViewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        userViewModel.all_Data.observe(this, {list->
            list?.let {
                adapter.updateList(it)
                i = adapter.sizeofdata()
            }
        })

        addbtn.setOnClickListener {
            gotoAddingPage()
        }

    }

    fun gotoAddingPage(){
        val intent = Intent(this@MainActivity, addingData::class.java)
        intent.putExtra("Rvalue", i)
        startActivity(intent)
    }

}