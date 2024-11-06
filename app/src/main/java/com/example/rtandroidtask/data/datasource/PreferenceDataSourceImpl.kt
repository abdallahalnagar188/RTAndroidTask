package com.example.rtandroidtask.data.datasource

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.rtandroidtask.domain.repo.PreferenceDataSource
import com.example.rtandroidtask.domain.utils.Constants.PREFERENCES_BASE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(PREFERENCES_BASE)


class PreferenceDataSourceImpl @Inject constructor(context: Context) :
    PreferenceDataSource {
    private val dataStore = context.dataStore

    override suspend fun getValue(key: String, default: Any?): Flow<Any?> {
        return dataStore.data.map {
            when (default) {
                is String -> {
                    it[stringPreferencesKey(key)] ?: default
                }

                is Double -> {
                    it[doublePreferencesKey(key)] ?: default
                }

                is Int -> {
                    it[intPreferencesKey(key)] ?: default
                }

                is Float -> {
                    it[floatPreferencesKey(key)] ?: default
                }

                is Boolean -> {
                    it[booleanPreferencesKey(key)] ?: default
                }

                is Long -> {
                    it[longPreferencesKey(key)] ?: default
                }

                else -> default
            }
        }
    }

    override suspend fun setValue(key: String, value: Any?) {
        dataStore.edit {
            when (value) {
                is String -> {
                    it[stringPreferencesKey(key)] = value
                }

                is Double -> {
                    it[doublePreferencesKey(key)] = value
                }

                is Int -> {
                    it[intPreferencesKey(key)] = value
                }

                is Float -> {
                    it[floatPreferencesKey(key)] = value
                }

                is Boolean -> {
                    it[booleanPreferencesKey(key)] = value
                }

                is Long -> {
                    it[longPreferencesKey(key)] = value
                }
            }
        }
    }

    override suspend fun removeValue() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {

    }

}