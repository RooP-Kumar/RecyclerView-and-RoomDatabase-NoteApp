package com.example.myapplication.Database

import androidx.lifecycle.LiveData
import com.example.myapplication.DataFile.Data
import kotlinx.coroutines.flow.Flow

class DataRepository(val dataDao: DataDao) {
    val allData: LiveData<List<Data>> = dataDao.allData()

    suspend fun addData(data: Data) {
        dataDao.insert(data)
    }

    suspend fun deleteData(data: Data) {
        dataDao.delete(data)
    }
}