package com.example.newthermometer.data.preferences.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PreferencesDao {
//    Make it into LiveData in the future
    @Query("SELECT * FROM preferences_table WHERE id = 0")
    fun getPreferences(): Flow<PreferencesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setPreferences(preferencesEntity: PreferencesEntity)

}