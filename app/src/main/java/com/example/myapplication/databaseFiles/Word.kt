package com.example.myapplication.databaseFiles

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class Word(@ColumnInfo(name = "Names")val KEY_NAME: String,
    @PrimaryKey(autoGenerate = true)val KEY_ID: Int = 0
)
