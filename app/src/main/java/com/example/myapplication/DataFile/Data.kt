package com.example.myapplication.DataFile

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data(
    @PrimaryKey()
    val key_id: Int,

    @ColumnInfo(name = "name")
    val key_name: String,

    @ColumnInfo(name = "description")
    val key_des: String
)