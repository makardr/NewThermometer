package com.example.newthermometer.data.preferences.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newthermometer.domain.preferences.model.MyPreferences


@Dao
interface PreferencesDao {
//    Make it into LiveData in the future
    @Query("SELECT * FROM preferences_table WHERE id = 0")
    suspend fun getPreferences(): MyPreferences?

//    Example
//    @Query("SELECT * FROM preferences_table WHERE id = :id")
//    fun getUserById(id: Int): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setPreferences(myPreferences: MyPreferences)

}