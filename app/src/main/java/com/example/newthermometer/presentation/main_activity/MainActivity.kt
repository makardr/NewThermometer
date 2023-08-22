package com.example.newthermometer.presentation.main_activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newthermometer.R
import com.example.newthermometer.domain.preferences.model.MyPreferences
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //AppCompatActivity for some reason crashes, would be necessary to figure out why
    //private val viewModel: MainActivityViewModel by viewModels()
    //private lateinit var viewModel: MainActivityViewModel
    private val viewModel: MainActivityViewModel by viewModels()
    val TAG = "MainActivity"
    lateinit var prefs: MyPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        //viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

//        // Observe LiveData from the ViewModel
//        viewModel.myLiveData.observe(this) { data ->
//            // Handle the data
//        }

        testFunction()


        setContentView(R.layout.settings_activity)

    }
    fun testFunction() {
        runBlocking {
            prefs = viewModel.ViewModelGetPreferences()
        }
        Log.d(TAG, prefs.refreshTimer.toString())
    }
}
