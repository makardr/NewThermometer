package com.example.newthermometer.presentation.main_activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val preferencesUseCases: PreferenceUseCases
) : ViewModel() {
    private val TAG="MainActivityViewModel"
    val preferencesLiveData: MutableLiveData<PreferencesEntity> by lazy {
        MutableLiveData<PreferencesEntity>()
    }

    init {
        Log.d(TAG, "Initialized")
        viewModelScope.launch {
            preferencesUseCases.getPreferences()
                .collectLatest { preferences ->
                    preferencesLiveData.postValue(preferences)
                }
        }
        Log.d(TAG, preferencesLiveData.value?.id.toString())

    }

    suspend fun ViewModelGetPreferences(): Flow<PreferencesEntity?> {
        return preferencesUseCases.getPreferences()
    }
}