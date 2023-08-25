package com.example.newthermometer.presentation.settings_activity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.newthermometer.domain.preferences.model.MyPreferences
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.NumberFormatException
import javax.inject.Inject

@HiltViewModel
class SettingsActivityViewModel @Inject constructor(
    private var preferencesUseCases: PreferenceUseCases
) : ViewModel() {
    private var TAG = "SettingsActivityViewModel"

    init {
        Log.d("MainActivityViewModelInit", "Initialized")

    }

    suspend fun getPreferences(): MyPreferences {
        return preferencesUseCases.getPreferences()
    }

    suspend fun setPreferences(
        address: String,
        refreshTimeString: String,
        temperatureLimitOneString: String,
        temperatureLimitTwoString: String
    ) {
        try {
            preferencesUseCases.setPreferences(MyPreferences(
                connectionAddress = address,
                refreshTime = refreshTimeString.toInt(),
                temperatureLimitOne = temperatureLimitOneString.toInt(),
                temperatureLimitTwo = temperatureLimitTwoString.toInt()
            ))
        } catch (_: NumberFormatException) {
            Log.e(TAG, "Input is wrong")
        }


        Log.d(TAG, "Preferences set")

    }
}