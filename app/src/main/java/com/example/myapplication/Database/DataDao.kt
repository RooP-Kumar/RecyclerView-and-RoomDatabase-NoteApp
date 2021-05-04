package com.example.myapplication.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.DataFile.Data
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: Data)

    @Delete
    suspend fun delete(data: Data)

    @Query("SELECT * FROM data")
    fun allData(): LiveData<List<Data>>
}