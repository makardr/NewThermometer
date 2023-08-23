package com.example.newthermometer.presentation.main_activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newthermometer.R
import com.example.newthermometer.domain.preferences.model.MyPreferences
import com.example.newthermometer.presentation.settings_activity.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking


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
