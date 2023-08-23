package com.example.newthermometer.presentation.settings_activity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.newthermometer.domain.preferences.model.MyPreferences
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class SettingsActivityViewModel @Inject constructor(
    private val preferencesUseCases: PreferenceUseCases
) : ViewModel() {
    var TAG = "SettingsActivityViewModel"
    init {
        Log.d("MainActivityViewModelInit", "Initialized")

    }

    suspend fun setPreferences(){
        Log.d(TAG, "Preferences set")
//        preferencesUseCases.setPreferences(preferences)
    }

    suspend fun ViewModelGetPreferences(): MyPreferences {
        return preferencesUseCases.getPreferences()
    }
}