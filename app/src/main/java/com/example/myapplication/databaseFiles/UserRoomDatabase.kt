package com.example.myapplication.databaseFiles

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class UserRoomDatabase: RoomDatabase() {
    abstract fun UserDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null
        fun getDatabase(context: Context): UserRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, UserRoomDatabase::class.java, "Users")
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}