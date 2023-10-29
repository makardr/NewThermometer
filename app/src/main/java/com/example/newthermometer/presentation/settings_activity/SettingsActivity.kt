package com.example.newthermometer.presentation.settings_activity

import android.os.Bundle

import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.newthermometer.R
import com.example.newthermometer.databinding.SettingsActivityBinding
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {
    private val viewModel: SettingsActivityViewModel by viewModels()
    private val TAG = "SettingsActivity"
    private lateinit var binding: SettingsActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.settings_activity)
//        TODO("""
//            It would actually will probably be better to use properties instead of that whole thing with database
//            Example:
//            val properties = Properties()
//                properties.load(ClassLoader.getSystemResourceAsStream("config.properties"))
//
//                val appValue = properties.getProperty("AppValue")
//                println("AppValue: $ appValue")
//
//        """.trimIndent())
//        Observe preferences
        val preferencesObserver = Observer<PreferencesEntity> {
            binding.tvAddress.text = it.connectionAddress
            binding.tvRefreshTime.text = it.refreshTime.toString()
            binding.tvLimitOne.text = it.temperatureLimitOne.toString()
            binding.tvLimitTwo.text = it.temperatureLimitTwo.toString()
        }

        viewModel.preferencesLiveData.observe(this, preferencesObserver)

//        Button to set preferences
        binding.btnSetPreferences.setOnClickListener {
            runBlocking {
                viewModel.setPreferencesViewModel(
                    binding.etAddress.text.toString(),
                    binding.etRefreshTime.text.toString(),
                    binding.etLimitOne.text.toString(),
                    binding.etLimitTwo.text.toString()
                )
            }
        }
    }
}