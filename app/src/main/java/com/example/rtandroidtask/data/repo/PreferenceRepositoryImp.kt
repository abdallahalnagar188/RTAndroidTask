package com.example.rtandroidtask.data.repo

import com.example.rtandroidtask.domain.repo.PreferenceDataSource
import com.example.rtandroidtask.domain.repo.PreferenceRepository
import com.example.rtandroidtask.domain.utils.Constants.IS_FIRST_TIME_PREFS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(private val preferenceDataSource: PreferenceDataSource) :
    PreferenceRepository {
    override suspend fun getIsFirstTime(): Flow<Boolean> {
        return flow {
            preferenceDataSource.getValue(IS_FIRST_TIME_PREFS, true).collect {
                emit(it as Boolean)
            }
        }
    }

    override suspend fun setIsFirstTime(firstTime: Boolean) {
        preferenceDataSource.setValue(IS_FIRST_TIME_PREFS, firstTime)
    }
}