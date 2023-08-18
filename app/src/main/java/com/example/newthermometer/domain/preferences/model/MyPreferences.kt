package com.example.newthermometer.domain.preferences.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newthermometer.core.values.Constants

@Entity(tableName = Constants.PREFERENCES_TABLE_NAME)
data class MyPreferences(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    val connectionAddress: String?,
    val refreshTimer: Int?,
    val temperatureLimitOne: Int?,
    val temperatureLimitTwo: Int?,
    // To be implemented in the future
    //val temperatureLimits: List<Int>?
)
