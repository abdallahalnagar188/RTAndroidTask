package com.example.rtandroidtask.presentation.ui.questions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rtandroidtask.presentation.theme.ExamateTheme

@Composable
fun OralQuestionsTextItem(modifier: Modifier = Modifier, titles: List<String>) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        titles.forEach {
            Surface(
                color = ExamateTheme.color.background,
                shape = ExamateTheme.shapes.small,
                modifier = Modifier
                    .width(60.dp)
                    .height(15.dp)
            ) {
                Text(
                    text = it,
                    style = ExamateTheme.typography.medium12,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center,
                    color = ExamateTheme.color.contentPrimary,
                )
            }
        }
    }
}