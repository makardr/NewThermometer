package com.example.newthermometer.presentation.main_activity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.newthermometer.domain.preferences.model.MyPreferences
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val preferencesUseCases: PreferenceUseCases
) : ViewModel() {
    init {
        Log.d("MainActivityViewModelInit", "Initialized")

    }

    suspend fun ViewModelGetPreferences(): MyPreferences {
        return preferencesUseCases.getPreferences()
    }
}