package com.example.newthermometer.di

import android.app.Application
import androidx.room.Room
import com.example.newthermometer.data.preferences.data_source.PreferencesDatabase
import com.example.newthermometer.data.preferences.repository.PreferencesRepositoryImpl
import com.example.newthermometer.domain.preferences.repository.PreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {
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
}