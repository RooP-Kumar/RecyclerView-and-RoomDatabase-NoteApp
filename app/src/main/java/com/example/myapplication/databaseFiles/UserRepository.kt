package com.example.myapplication.databaseFiles

import kotlinx.coroutines.flow.Flow

class UserRepository(val UserDao: UserDao) {
    val all_Data: Flow<List<Word>> = UserDao.allData()

    suspend fun addData(word: Word) {
        UserDao.insert(word)
    }

    suspend fun deleteData(word: Word) {
        UserDao.delete(word)
    }
}