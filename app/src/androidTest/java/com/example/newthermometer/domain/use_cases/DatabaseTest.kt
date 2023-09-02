package com.example.newthermometer.domain.use_cases

import com.example.newthermometer.di.PreferencesModule
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
@UninstallModules(PreferencesModule::class)
class DatabaseTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var preferencesUseCases: PreferenceUseCases

    val TAG = "androidTest"

    @Before
    fun setUp() {
        hiltRule.inject()
    }



    @Test
    fun databaseFreshReturnsNull() = runTest {
        preferencesUseCases.getPreferences()
            .take(1)
            .collect { preferencesEntity ->
                assertThat(preferencesEntity).isNull()
            }
    }

    @Test
    fun databaseWriteReturnsNotNull() = runTest {
        preferencesUseCases.setPreferences(PreferencesEntity(connectionAddress = "Test"))
        preferencesUseCases.getPreferences()
            .take(1)
            .collect { preferencesEntity ->
                assertThat(preferencesEntity).isNotNull()
            }
    }
    @Test
    fun writeAndReadDatabase() = runTest {
        val testValueAddress="Test address"

        preferencesUseCases.setPreferences(PreferencesEntity(connectionAddress = testValueAddress))
        preferencesUseCases.getPreferences()
            .take(1)
            .collect { preferencesEntity ->
                if (preferencesEntity != null){
                    assertThat(preferencesEntity.connectionAddress).isEqualTo(testValueAddress)
                }

            }
    }

    @Test
    fun flowTest() = runTest {
        var testVar = 0
        val myDataFlow = flow {
            for (i in 1..3) {
                emit(i)
            }
        }

        myDataFlow.collect { data ->
            println(data)
            testVar = data
//            assertThat(data).isEqualTo(1)
        }
        assertThat(testVar).isEqualTo(3)
    }
}