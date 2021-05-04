package com.example.myapplication.Database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.DataFile.Data
import kotlinx.coroutines.launch

class DataViewModel(application: Application): AndroidViewModel(application) {
    val all_Data: LiveData<List<Data>>
    val repository: DataRepository
    init {
        val dataDao = UserRoomDatabase.getDatabase(application).DataDao()
        repository = DataRepository(dataDao)
        all_Data = repository.allData
    }

    fun add_Data(data: Data) = viewModelScope.launch {
        repository.addData(data)
    }

    fun delete_Data(data: Data) = viewModelScope.launch {
        repository.deleteData(data)
    }
}