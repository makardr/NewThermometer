package com.example.newthermometer.presentation.settings_activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import com.example.newthermometer.presentation.settings_activity.input_validation.NegativeNumberException
import com.example.newthermometer.presentation.settings_activity.input_validation.NotANumberException
import com.example.newthermometer.presentation.settings_activity.input_validation.OutOfRangeException
import com.example.newthermometer.presentation.settings_activity.input_validation.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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
                        preferencesLiveData.postValue(preferencesStaringValue)
//                        TODO("Better handling of empty database")
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
        var validation = validatePreferencesEntity(address, refreshTimeString, temperatureLimitOneString, temperatureLimitTwoString)
        when (validation){
            is ValidationResult.Success -> preferencesUseCases.setPreferences(validation.validatedData)
            is ValidationResult.Exception -> Log.e(TAG,validation.error.toString())
        }
    }


    fun validatePreferencesEntity(address:String,refresh: String,limitOne: String,limitTwo:String): ValidationResult{
//        Check if convertable to int and not null
        if (
            refresh.toIntOrNull()!=null &&
            limitOne.toIntOrNull()!=null &&
            limitTwo.toIntOrNull()!=null
        ){
            //        Check if numbers are not negative
            if (
                refresh.toInt() >= 0 &&
                limitOne.toInt()  >= 0 &&
                limitTwo.toInt()  >= 0
            ){
                //        Check if numbers are within range
                if (true){
                    return ValidationResult.Success(PreferencesEntity(
                        connectionAddress = address,
                        refreshTime = refresh.toInt(),
                        temperatureLimitOne = limitOne.toInt(),
                        temperatureLimitTwo = limitTwo.toInt()
                    ))
                }else{
                    return ValidationResult.Exception(OutOfRangeException())
                }
            }else{
                return ValidationResult.Exception(NegativeNumberException())
            }
        }else{
            return ValidationResult.Exception(NotANumberException())
        }
    }
}