package com.example.newthermometer.data.preferences.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PreferencesDao {
    @Query("SELECT * FROM preferences_table LIMIT 1")
    fun getPreferences(): Flow<PreferencesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setPreferences(preferencesEntity: PreferencesEntity)

}