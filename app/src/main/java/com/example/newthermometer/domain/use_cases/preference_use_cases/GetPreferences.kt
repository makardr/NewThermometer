package com.example.newthermometer.domain.use_cases.preference_use_cases

import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository
import kotlinx.coroutines.flow.Flow

class GetPreferences(
    private val repository: PreferencesRepository
) {
    //If transfer to flow remove suspend
    operator fun invoke():Flow<PreferencesEntity?>{
        return repository.getPreferences()
    }
}