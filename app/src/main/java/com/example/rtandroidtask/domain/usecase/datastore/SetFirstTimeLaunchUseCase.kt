package com.example.rtandroidtask.domain.usecase.datastore

import com.example.rtandroidtask.domain.repo.PreferenceRepository
import javax.inject.Inject

class SetFirstTimeLaunchUseCase  @Inject constructor(
    private val preferenceRepository: PreferenceRepository
) {
    suspend operator fun invoke(isFirstTime: Boolean) = preferenceRepository.setIsFirstTime(isFirstTime)
}