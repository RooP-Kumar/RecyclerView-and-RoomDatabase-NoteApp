package com.example.myapplication.Adapter

import android.content.Context
import android.os.Handler
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databaseFiles.UserViewModel
import com.example.myapplication.databaseFiles.Word
import kotlinx.android.synthetic.main.recycler_view.view.*
import org.w3c.dom.Text

class MyAdapter(private val context: Context, val userViewModel: UserViewModel) : RecyclerView.Adapter<MyAdapter.MyHandler>() {
    var all_data = ArrayList<Word>()
    class MyHandler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text = itemView.findViewById<TextView>(R.id.set_text_here)
        val deleteBtn = itemView.findViewById<ImageView>(R.id.deleteBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHandler {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view, parent,false)
        return MyHandler(view)
    }

    override fun onBindViewHolder(holder: MyHandler, position: Int) {
        holder.text.text = all_data[position].KEY_NAME.toString()
        holder.deleteBtn.setOnClickListener {
            deleteItem(position)
        }
    }

    override fun getItemCount(): Int {
        return all_data.size
    }

    fun updateList(item: List<Word>) {
        all_data.clear()
        all_data.addAll(item)
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        userViewModel.delete_Data(all_data[position])
        notifyDataSetChanged()
    }
}