package com.example.newthermometer.presentation.main_activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.newthermometer.R
import com.example.newthermometer.data.preferences.data_source.PreferencesDatabase
import com.example.newthermometer.presentation.settings_activity.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        startIntent()
    }

    fun startIntent(){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}
