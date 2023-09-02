package com.example.newthermometer.presentation.settings_activity


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.newthermometer.di.PreferencesModule
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.use_cases.preference_use_cases.GetPreferences
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import com.example.newthermometer.domain.use_cases.preference_use_cases.SetPreferences
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(PreferencesModule::class)
class SettingsActivityViewModelTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var preferencesUseCases: PreferenceUseCases

    private lateinit var viewModel: SettingsActivityViewModel


    @Before
    fun setUp() {
        hiltRule.inject()

        viewModel = SettingsActivityViewModel(preferencesUseCases)
    }


//    @Test
//    fun `Write in database and check if database flow emits values when it changes`() = runTest {
//
//        val testPreferencesRepositoryImpl = TestPreferencesRepositoryImpl()
//        val getPreferences = GetPreferences(testPreferencesRepositoryImpl)
//        val setPreferences = SetPreferences(testPreferencesRepositoryImpl)
//
//        val address = "Test connection address"
//
//
//        setPreferences(PreferencesEntity(connectionAddress = address))
//        getPreferences().collect {
//            assertThat(it).isNotNull()
//            if (it != null) {
//                assertThat(it.connectionAddress).isEqualTo(address)
//            }
//        }
//    }


    @Test
    fun getPreferencesLiveData() {
        assertThat(viewModel.preferencesLiveData).isNotNull()

    }

    @Test
    fun setPreferencesViewModel() {
    }

    @Test
    fun validatePreferencesEntity() {
    }

    @Test
    fun preferencesEntityValidationIsCorrect() {
        assertThat(viewModel.validatePreferencesEntity(PreferencesEntity(connectionAddress = "Test"))).isTrue()
    }

    @Test
    fun preferencesEntityValidationIsIncorrect() {
    }
}