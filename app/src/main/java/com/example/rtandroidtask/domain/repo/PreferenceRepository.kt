package com.example.rtandroidtask.domain.repo

import kotlinx.coroutines.flow.Flow

interface PreferenceRepository {

    suspend fun getIsFirstTime(): Flow<Boolean>
    suspend fun setIsFirstTime(firstTime: Boolean)

}