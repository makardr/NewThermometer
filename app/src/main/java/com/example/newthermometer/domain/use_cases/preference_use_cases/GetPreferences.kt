package com.example.newthermometer.domain.use_cases.preference_use_cases

import com.example.newthermometer.domain.preferences.model.MyPreferences
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository

class GetPreferences(
    private val repository: PreferencesRepository
) {
    //If transfer to flow remove suspend
    suspend operator fun invoke():MyPreferences{
        return repository.getPreferences()
    }
}