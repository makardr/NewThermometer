package com.example.newthermometer.presentation.main_activity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val preferencesUseCases: PreferenceUseCases
) : ViewModel() {
    init {
        Log.d("MainActivityViewModelInit", "Initialized")

    }

    fun ViewModelGetPreferences(): Flow<PreferencesEntity?> {
        return preferencesUseCases.getPreferences()
    }
}