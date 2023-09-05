package com.example.newthermometer.data.preferences.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import kotlinx.coroutines.flow.firstOrNull


@Database(
    entities = [PreferencesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PreferencesDatabase: RoomDatabase() {

    private val defaultPreferences = PreferencesEntity(connectionAddress = "")
    abstract val preferencesDao: PreferencesDao

    suspend fun initializeDatabase() {
        if (preferencesDao.getPreferences().firstOrNull() == null) {
            preferencesDao.setPreferences(defaultPreferences)
        }
    }
    companion object {
        const val DATABASE_NAME = "preferences_db"
    }
}