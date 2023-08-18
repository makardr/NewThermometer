package com.example.newthermometer.domain.temperature.repository

import com.example.newthermometer.domain.temperature.model.Value

interface TemperatureRepository {
    fun saveTemperatureValue(value: Value)
    fun getTemperature(id: Int): Value
    fun getTemperatures():List<Value>
}