package com.example.rtandroidtask.data.models

import com.example.rtandroidtask.R

data class WritingQuestionsModel(
    val question: String = "",
    val type: String = "",
    val progress: Float,
    val icon: Int,
    val answersCount: Int = 0,
    val questionsCount: Int = 0
)
val writingsList = listOf(
    WritingQuestionsModel(
        type = "Voyage",
        answersCount = 10,
        questionsCount = 10,
        progress = 100f,
        icon = R.drawable.ic_art
    ),
    WritingQuestionsModel(
        type = "Immigration",
        answersCount = 6,
        questionsCount = 10,
        progress = 65f,
        icon = R.drawable.ic_enviroment
    ),
    WritingQuestionsModel(
        type = "Technologie",
        answersCount = 4,
        questionsCount = 10,
        progress = 40f,
        icon = R.drawable.ic_tech
    ),
    WritingQuestionsModel(
        type = "Art et Culture",
        answersCount = 4,
        questionsCount = 10,
        progress = 90f,
        icon = R.drawable.ic_art
    ),
    WritingQuestionsModel(
        type = "Environm-ent ",
        answersCount = 5,
        questionsCount = 10,
        progress = 30f,
        icon = R.drawable.ic_enviroment
    ),
    WritingQuestionsModel(
        type = "Art et Culture",
        answersCount = 4,
        questionsCount = 10,
        progress = 80f,
        icon = R.drawable.ic_art
    ),
    WritingQuestionsModel(
        type = "Travel",
        answersCount = 3,
        questionsCount = 10,
        progress = 20f,
        icon = R.drawable.ic_enviroment
    )
)