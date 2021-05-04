package com.example.myapplication.databaseFiles

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    val all_Data: LiveData<List<Word>>
    val repository: UserRepository
    init {
        val dataDao = UserRoomDatabase.getDatabase(application).UserDao()
        repository = UserRepository(dataDao)
        all_Data = repository.all_Data.asLiveData()
    }

    fun add_Data(word: Word) = viewModelScope.launch {
        repository.addData(word)
    }

    fun delete_Data(word: Word) = viewModelScope.launch {
        repository.deleteData(word)
    }
}