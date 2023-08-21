package com.example.newthermometer.data.preferences.repository

import com.example.newthermometer.domain.preferences.model.MyPreferences
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository

class TestPreferencesRepository :PreferencesRepository{
    override suspend fun getPreferences(): MyPreferences {
        TODO("Not yet implemented")
    }

    override suspend fun setPreferences(myPreferences: MyPreferences) {
        TODO("Not yet implemented")
    }
}