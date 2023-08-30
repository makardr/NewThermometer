package com.example.newthermometer.data.preferences.repository

import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository
import kotlinx.coroutines.flow.Flow

class TestPreferencesRepository :PreferencesRepository{
    override fun getPreferences(): Flow<PreferencesEntity?> {
        TODO("Not yet implemented")
    }

    override suspend fun setPreferences(preferencesEntity: PreferencesEntity) {
        TODO("Not yet implemented")
    }
}