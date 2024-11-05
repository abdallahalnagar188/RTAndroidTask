package com.example.rtandroidtask.data.models

data class ProgressStepItemData(
    val stepNumber: Int,
    val title: String,
    val isCompleted: Boolean,
    val progress: Float,
    val isLocked: Boolean
)