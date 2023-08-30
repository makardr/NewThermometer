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
//        dao.getPreferences().let { prefFlow ->
//            prefFlow
//                .onEmpty {
//                    Log.d(TAG, "onEmpty")
//                }
//                .onStart {
//                    Log.d(TAG, "onStart")
//                    if(this==null){
//                        Log.d(TAG, "This is null, setting up PreferencesEntity")
//                        setPreferences(PreferencesEntity(connectionAddress = "test preferences"))
//                    }
//                }
//                .catch { exception ->
//                    Log.e(TAG, exception.message.toString())
//                }
//                .collectLatest {
//                    Log.d(TAG, "Object is " + it.toString())
//
//                }
//            return prefFlow
//        }
        return dao.getPreferences()
    }

    override suspend fun setPreferences(preferencesEntity: PreferencesEntity) {
        Log.d(TAG, "Preferences were set")
        dao.setPreferences(preferencesEntity)
    }
}