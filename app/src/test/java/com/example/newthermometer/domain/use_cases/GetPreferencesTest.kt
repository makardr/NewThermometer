package com.example.newthermometer.domain.use_cases


import com.example.newthermometer.domain.preferences.repository.PreferencesRepository
import com.example.newthermometer.domain.use_cases.preference_use_cases.GetPreferences
import kotlinx.coroutines.runBlocking


import org.junit.Before
import org.junit.Test


class GetPreferencesTest {

    private lateinit var getPreferences: GetPreferences
    private lateinit var fakeRepository: PreferencesRepository

    @Before
    fun setUp() {
    }

    @Test
    fun databaseFreshReturnsNull() = runBlocking{
    }
}