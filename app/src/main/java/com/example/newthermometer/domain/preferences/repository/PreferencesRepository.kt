package com.example.newthermometer.domain.preferences.repository

import com.example.newthermometer.domain.preferences.model.MyPreferences

interface PreferencesRepository {
//    When I will transfer to live data I think I will have to make getPreferences not suspend
    suspend fun getPreferences(): MyPreferences?
    suspend fun setPreferences(myPreferences: MyPreferences)
}