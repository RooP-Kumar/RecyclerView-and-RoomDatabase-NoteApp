package com.example.myapplication.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.*
import androidx.room.RoomDatabase
import com.example.myapplication.DataFile.Data

@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class UserRoomDatabase: RoomDatabase() {
    abstract fun DataDao() : DataDao

    companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context): UserRoomDatabase {
            val tempinstance = INSTANCE
            if (tempinstance != null) {
                return tempinstance
            }
            val instance = Room.databaseBuilder(context, UserRoomDatabase::class.java, "Data")
                    .build()
            INSTANCE = instance
            return instance
            }
        }

    }