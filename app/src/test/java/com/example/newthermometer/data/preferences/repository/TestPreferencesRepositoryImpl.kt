package com.example.newthermometer.data.preferences.repository

import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestPreferencesRepositoryImpl : PreferencesRepository{
    private var preferencesEntity = PreferencesEntity(connectionAddress = null)
    override suspend fun getPreferences(): Flow<PreferencesEntity> {
        return flow {
            emit(preferencesEntity)
        }
    }

    override suspend fun setPreferences(preferencesEntity: PreferencesEntity) {
        this.preferencesEntity = preferencesEntity
    }
}