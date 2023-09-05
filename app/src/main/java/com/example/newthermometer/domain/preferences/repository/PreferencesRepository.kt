package com.example.newthermometer.domain.preferences.repository

import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import kotlinx.coroutines.flow.Flow

interface PreferencesRepository {
    suspend fun getPreferences(): Flow<PreferencesEntity>
    suspend fun setPreferences(preferencesEntity: PreferencesEntity)
}