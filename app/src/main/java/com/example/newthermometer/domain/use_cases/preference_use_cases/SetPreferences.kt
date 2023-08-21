package com.example.newthermometer.domain.use_cases.preference_use_cases

import com.example.newthermometer.domain.preferences.model.MyPreferences
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository

class SetPreferences(
    private val repository: PreferencesRepository
) {
    suspend operator fun invoke(): MyPreferences{
        return repository.getPreferences()
    }
}