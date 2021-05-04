package com.example.myapplication.RecyclerViewAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DataFile.Data
import com.example.myapplication.Database.DataViewModel
import com.example.myapplication.R
import com.example.myapplication.showingDescription

class MyAdapter(val context: Context, val userViewModel: DataViewModel): RecyclerView.Adapter<MyAdapter.MyHolder>() {
    val all_data = ArrayList<Data>()
    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textview = itemView.findViewById<TextView>(R.id.texttoshow)
        val deletebtn = itemView.findViewById<ImageView>(R.id.delete_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        return MyHolder(inflate)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.textview.text = all_data[position].key_name
        holder.deletebtn.setOnClickListener {
            delteItem(all_data[position])
        }
        holder.textview.setOnClickListener {
            showDes(all_data[position])
        }
    }

    override fun getItemCount(): Int {
        return all_data.size
    }

    fun delteItem(data: Data){
        userViewModel.delete_Data(data)
    }

    fun showDes(data: Data) {
        val intent = Intent(context, showingDescription::class.java)
        intent.putExtra("Rname", data.key_name)
        intent.putExtra("Rdes", data.key_des)
        context.startActivity(intent)
    }

    fun updateList(item: List<Data>){
        all_data.clear()
        all_data.addAll(item)
        notifyDataSetChanged()
    }

    fun sizeofdata(): Int {
        return all_data.size
    }
}