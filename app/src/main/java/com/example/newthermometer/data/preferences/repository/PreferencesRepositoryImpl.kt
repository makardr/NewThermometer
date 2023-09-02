package com.example.newthermometer.data.preferences.repository

import android.util.Log
import com.example.newthermometer.data.preferences.data_source.PreferencesDao
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart

class PreferencesRepositoryImpl(
    private val dao: PreferencesDao
) : PreferencesRepository {
    private val TAG = "PreferencesRepositoryImpl"

    override fun getPreferences(): Flow<PreferencesEntity?> {
        return dao.getPreferences()
    }

    override suspend fun setPreferences(preferencesEntity: PreferencesEntity) {
        Log.d(TAG, "Preferences were set")
        dao.setPreferences(preferencesEntity)
    }
}