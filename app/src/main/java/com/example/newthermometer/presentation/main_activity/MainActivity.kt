package com.example.newthermometer.presentation.main_activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.newthermometer.R
import com.example.newthermometer.databinding.MainActivityBinding
import com.example.newthermometer.domain.preferences.model.PreferencesEntity
import com.example.newthermometer.presentation.settings_activity.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: MainActivityBinding
    private val TAG = "MainActivity"
    private lateinit var preferencesEntity: PreferencesEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        binding.btnSettings.setOnClickListener {
            Log.d(TAG, "Button pressed")
            startIntent()
        }


    }

    fun startIntent(){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}
