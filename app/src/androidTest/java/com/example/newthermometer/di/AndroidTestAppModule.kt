package com.example.newthermometer.di

import android.app.Application
import androidx.room.Room
import com.example.newthermometer.data.preferences.data_source.PreferencesDatabase
import com.example.newthermometer.data.preferences.repository.PreferencesRepositoryImpl
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository
import com.example.newthermometer.domain.use_cases.preference_use_cases.GetPreferences
import com.example.newthermometer.domain.use_cases.preference_use_cases.PreferenceUseCases
import com.example.newthermometer.domain.use_cases.preference_use_cases.SetPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AndroidTestAppModule {
    @Provides
    @Singleton
    fun providePreferencesDatabase(app: Application): PreferencesDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            PreferencesDatabase::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun providePreferencesRepository(database: PreferencesDatabase): PreferencesRepository {
        return PreferencesRepositoryImpl(database.preferencesDao)
    }

    @Provides
    @Singleton
    fun providePreferencesUseCases(repository: PreferencesRepository): PreferenceUseCases {
        return PreferenceUseCases(
            getPreferences = GetPreferences(repository), setPreferences = SetPreferences(repository)
        )
    }
}