package com.example.rtandroidtask.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rtandroidtask.R
import com.example.rtandroidtask.data.models.ProgressStepItemData

@Composable
internal fun ProgressSteps() {
    val listItem = listOf(
        ProgressStepItemData(1, "Unite 1:\nwhat is examate", false, 1f, false),
        ProgressStepItemData(2, "Unite 2:\nwhat is TCF", false, 0.6f, false),
        ProgressStepItemData(3, "Unite 3:\nWriting Tasks", true, 0f, true),
        ProgressStepItemData(4, "Unite 4:\nOral Task", true, 0f, true),
        ProgressStepItemData(5, "Unite 5:\nListening Task", true, 0f, true),
        ProgressStepItemData(6, "Unite 6:\nReading Task", true, 0f, true),
        ProgressStepItemData(7, "Unite 7:\nSpeaking Task", true, 0f, true),
    )
    Text(
        text = "Study Plan",
        color = colorResource(id = R.color.primary_800),
        modifier = Modifier
            .padding(start = 12.dp,bottom = 10.dp).fillMaxWidth()
            .displayCutoutPadding(),
        fontFamily = com.example.rtandroidtask.presentation.ui.common.fontBold,
        fontSize = 24.sp,
        textAlign = TextAlign.Start,
    )
    LazyColumn(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxWidth()
            .background(color = androidx.compose.ui.graphics.Color.White)
            .padding(10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        itemsIndexed(listItem) { index, item ->
            HomeProgressItem(
                stepNumber = item.stepNumber,
                title = item.title,
                isCompleted = item.isCompleted,
                progress = item.progress,
                isLocked = item.isLocked,
                showLine = index != listItem.size - 1
            )
        }
    }

}