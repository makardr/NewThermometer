package com.example.newthermometer.domain.use_cases

import com.example.newthermometer.di.AppModule
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
@UninstallModules(AppModule::class)
class DatabaseTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    //private lateinit var getPreferences: GetPreferences
    @Inject
    private lateinit var fakeRepository: PreferencesRepository

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun databaseFreshReturnsNull() = runBlocking {
        val preferences = fakeRepository.getPreferences()
        Truth.assertThat(preferences).isNull()
    }

}