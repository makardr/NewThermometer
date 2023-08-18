package com.example.newthermometer.domain.temperature.model


data class Value(
    val temperatureInt: Int,
    val timestamp: Long,
    val id: Int? = null
)
