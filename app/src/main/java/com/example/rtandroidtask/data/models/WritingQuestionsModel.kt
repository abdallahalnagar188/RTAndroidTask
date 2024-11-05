package com.example.rtandroidtask.data.models

data class WritingQuestionsModel(
    val question: String = "",
    val type: String = "",
    val progress: Float,
    val icon: Int,
    val answersCount: Int = 0,
    val questionsCount: Int = 0
)