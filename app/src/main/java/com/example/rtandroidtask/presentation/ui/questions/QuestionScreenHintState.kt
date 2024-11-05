package com.example.rtandroidtask.presentation.ui.questions

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class QuestionScreenHintState(
    val isFilterHintVisible: MutableState<Boolean> = mutableStateOf(false),
    val isToolsHintVisible: MutableState<Boolean> = mutableStateOf(false),
    val isFirstItemHintVisible: MutableState<Boolean> = mutableStateOf(false)
)