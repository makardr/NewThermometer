package com.example.newthermometer.presentation.settings_activity

import android.os.Bundle

import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.newthermometer.R
import com.example.newthermometer.databinding.SettingsActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {
    private val viewModel: SettingsActivityViewModel by viewModels()
    private val TAG = "SettingsActivity"
    private lateinit var binding: SettingsActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        binding = DataBindingUtil.setContentView(this, R.layout.settings_activity)

        val btnSetPreferences = findViewById<Button>(R.id.btnSetPreferences)
        btnSetPreferences.setOnClickListener {
            runBlocking {
                viewModel.setPreferences(
                    binding.etAddress.text.toString(),
                    binding.etRefreshTime.text.toString(),
                    binding.etLimitOne.text.toString(),
                    binding.etLimitTwo.text.toString())
            }
        }

        runBlocking {
            binding.tvAddress.text = viewModel.getPreferences().connectionAddress
            binding.tvRefreshTime.text = viewModel.getPreferences().refreshTime.toString()
            binding.tvLimitOne.text = viewModel.getPreferences().temperatureLimitOne.toString()
            binding.tvLimitTwo.text = viewModel.getPreferences().temperatureLimitTwo.toString()
        }

    }


}