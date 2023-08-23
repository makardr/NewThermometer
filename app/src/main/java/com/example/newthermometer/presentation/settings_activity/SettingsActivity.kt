package com.example.newthermometer.presentation.settings_activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.newthermometer.R
import com.example.newthermometer.databinding.SettingsActivityBinding
import com.example.newthermometer.presentation.main_activity.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {
    private val viewModel: SettingsActivityViewModel by viewModels()
    val TAG = "SettingsActivity"
    private lateinit var binding: SettingsActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        binding = DataBindingUtil.setContentView(this, R.layout.settings_activity)
        val btnSetPreferences = findViewById<Button>(R.id.btnSetPreferences)
        btnSetPreferences.setOnClickListener {
            runBlocking {
                viewModel.setPreferences()
            }
        }
        runBlocking {
            Log.d(TAG, viewModel.ViewModelGetPreferences().temperatureLimitOne.toString())
            binding.tvId.text = viewModel.ViewModelGetPreferences().id.toString()
            binding.tvAddress.text = viewModel.ViewModelGetPreferences().connectionAddress
            binding.tvRefreshTime.text = viewModel.ViewModelGetPreferences().refreshTime.toString()
            binding.tvLimitOne.text = viewModel.ViewModelGetPreferences().temperatureLimitOne.toString()
            binding.tvLimitTwo.text = viewModel.ViewModelGetPreferences().temperatureLimitTwo.toString()
        }

    }
}