package com.example.newthermometer.data.preferences.repository

import com.example.newthermometer.data.preferences.data_source.PreferencesDao
import com.example.newthermometer.domain.preferences.model.MyPreferences
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository

class PreferencesRepositoryImpl(
    private val dao: PreferencesDao
) : PreferencesRepository {
    override suspend fun getPreferences(): MyPreferences {
        return dao.getPreferences() ?: run {
            val preferences = MyPreferences(connectionAddress = null)
            setPreferences(preferences)
            preferences
        }
    }

    override suspend fun setPreferences(myPreferences: MyPreferences) {
        dao.setPreferences(myPreferences)
    }
}