package com.example.newthermometer.presentation.settings_activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.NumberFormatException
import javax.inject.Inject

@HiltViewModel
class SettingsActivityViewModel @Inject constructor(
    private var preferencesUseCases: PreferenceUseCases
) : ViewModel() {
    private var TAG = "SettingsActivityViewModel"
    private var preferencesStaringValue = PreferencesEntity(connectionAddress = "none")

    val preferencesLiveData: MutableLiveData<PreferencesEntity> by lazy {
        MutableLiveData<PreferencesEntity>()
    }

    init {
        preferencesLiveData.postValue(preferencesStaringValue)
        viewModelScope.launch {
            preferencesUseCases.getPreferences()
                .collectLatest { preferences ->
                    if (preferences != null) {
                        Log.d(TAG, preferences.connectionAddress.toString())
                        preferencesLiveData.postValue(preferences)
                    } else {
                        preferencesUseCases.setPreferences(preferencesStaringValue)
                        preferencesLiveData.postValue(preferences)
                    }
                }
        }
    }

    suspend fun setPreferencesViewModel(
        address: String,
        refreshTimeString: String,
        temperatureLimitOneString: String,
        temperatureLimitTwoString: String
    ) {
        try {
            preferencesUseCases.setPreferences(
                PreferencesEntity(
                    connectionAddress = address,
                    refreshTime = refreshTimeString.toInt(),
                    temperatureLimitOne = temperatureLimitOneString.toInt(),
                    temperatureLimitTwo = temperatureLimitTwoString.toInt()
                )
            )
        } catch (_: NumberFormatException) {
            Log.e(TAG, "Input is wrong")
        }
    }


    fun validatePreferencesEntity(preferencesEntity: PreferencesEntity): Boolean{


        return true
    }
}