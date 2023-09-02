package com.example.newthermometer.presentation.settings_activity.input_validation

import com.example.newthermometer.domain.preferences.model.PreferencesEntity

sealed class ValidationResult{
    data class Success(val validatedData:PreferencesEntity): ValidationResult()
    data class Exception(val error:Throwable?):ValidationResult()
}
