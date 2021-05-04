package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.MyAdapter
import com.example.myapplication.databaseFiles.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(UserViewModel::class.java)
        setContentView(R.layout.activity_main)
        adapter = MyAdapter(this, userViewModel)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        userViewModel.all_Data.observe(this, {list ->
            list?.let {
                adapter.updateList(it)
            }
        })

        floatingActionButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }

    }

}