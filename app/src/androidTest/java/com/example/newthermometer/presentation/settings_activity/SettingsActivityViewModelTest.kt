package com.example.newthermometer.presentation.settings_activity


import com.example.newthermometer.di.PreferencesModule
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import com.example.newthermometer.presentation.settings_activity.input_validation.NegativeNumberException
import com.example.newthermometer.presentation.settings_activity.input_validation.NotANumberException
import com.example.newthermometer.presentation.settings_activity.input_validation.ValidationResult
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
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
    fun preferencesEntitySuccess() {
        val address = "Test"
        val refreshTimeString= "7"
        val tLimitOne = "50"
        val tLimitTwo = "60"

        assertThat(viewModel.validatePreferencesEntity(address,refreshTimeString,tLimitOne,tLimitTwo)).isEqualTo(
            ValidationResult.Success(PreferencesEntity(connectionAddress = address, refreshTime = refreshTimeString.toInt(), temperatureLimitOne = tLimitOne.toInt(), temperatureLimitTwo = tLimitTwo.toInt()))
        )

    }
    @Test
    fun preferencesEntityNegativeIntegersNegativeNumbersException() {
        val address = "Test"
        val refreshTimeString= "-7"
        val tLimitOne = "-50"
        val tLimitTwo = "-60"

        val result = viewModel.validatePreferencesEntity(address,refreshTimeString,tLimitOne,tLimitTwo)

        assertThat(result).isInstanceOf(ValidationResult.Exception::class.java)
        assertThat((result as ValidationResult.Exception).error).isInstanceOf(NegativeNumberException::class.java)
    }

    @Test
    fun preferencesEntityValidationNotANumberException() {
        val address = "Test"
        val refreshTimeString= "t"
        val tLimitOne = "t"
        val tLimitTwo = "t"

        val result = viewModel.validatePreferencesEntity(address,refreshTimeString,tLimitOne,tLimitTwo)
        assertThat(result).isInstanceOf(
            ValidationResult.Exception::class.java
        )
        assertThat((result as ValidationResult.Exception).error).isInstanceOf(NotANumberException::class.java)
//        assertThat((result.error as NotANumberException).message).isEqualTo(NotANumberException())
    }

    @Test
    fun preferencesEntityValidationIsNullNotANumberException() {
        val address = ""
        val refreshTimeString= ""
        val tLimitOne = ""
        val tLimitTwo = ""
        val result = viewModel.validatePreferencesEntity(address,refreshTimeString,tLimitOne,tLimitTwo)

        assertThat(result).isInstanceOf(ValidationResult.Exception::class.java)
        assertThat((result as ValidationResult.Exception).error).isInstanceOf(NotANumberException::class.java)
    }

    @Test
    fun preferencesEntityValidationIsFloatNotANumberException() {
        val address = "dasfda"
        val refreshTimeString= "1,2"
        val tLimitOne = "1,3"
        val tLimitTwo = "1,2"
        val result = viewModel.validatePreferencesEntity(address,refreshTimeString,tLimitOne,tLimitTwo)

        assertThat(result).isInstanceOf(ValidationResult.Exception::class.java)
        assertThat((result as ValidationResult.Exception).error).isInstanceOf(NotANumberException::class.java)
    }
}