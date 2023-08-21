package com.example.newthermometer.data.preferences.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newthermometer.domain.preferences.model.MyPreferences


@Database(
    entities = [MyPreferences::class],
    version = 1,
    exportSchema = false
)
abstract class PreferencesDatabase: RoomDatabase() {


    abstract val preferencesDao: PreferencesDao

    companion object {
        const val DATABASE_NAME = "preferences_db"
    }
}