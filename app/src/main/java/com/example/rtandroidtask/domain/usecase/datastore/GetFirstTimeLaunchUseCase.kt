package com.example.rtandroidtask.domain.usecase.datastore

import com.example.rtandroidtask.domain.repo.PreferenceRepository
import javax.inject.Inject

class GetFirstTimeLaunchUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository
) {
    suspend operator fun invoke() = preferenceRepository.getIsFirstTime()
}