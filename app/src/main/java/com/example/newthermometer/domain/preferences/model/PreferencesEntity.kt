package com.example.newthermometer.domain.preferences.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newthermometer.core.values.Constants
import kotlinx.coroutines.flow.Flow

@Entity(tableName = Constants.PREFERENCES_TABLE_NAME)
data class PreferencesEntity(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    val connectionAddress: String?,
    val refreshTime: Int = 5,
    val temperatureLimitOne: Int = 50,
    val temperatureLimitTwo: Int = 60,
    // To be implemented in the future?
    //val temperatureLimits: List<Int>?
)

class InvalidPreferencesException(message: String): Exception(message)