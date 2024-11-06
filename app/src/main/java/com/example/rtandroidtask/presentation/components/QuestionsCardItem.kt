package com.example.rtandroidtask.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.rtandroidtask.R
import com.example.rtandroidtask.data.models.OralQuestionsModel
import com.example.rtandroidtask.domain.model.questions.WritingQuestionsModel
import com.example.rtandroidtask.presentation.theme.ExamateTheme


@Composable
internal fun OralQuestionsCard(
    questionItem: OralQuestionsModel
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = ExamateTheme.color.white),
        shape = ExamateTheme.shapes.large,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                OralQuestionsTextItem(modifier = Modifier.weight(1f), questionItem.titles)
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Outlined.MoreVert,
                        contentDescription = "Home",
                        tint = ExamateTheme.color.black,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }
            Text(
                text = questionItem.question,
                style = ExamateTheme.typography.medium14,
                color = ExamateTheme.color.contentPrimary
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(3.dp)
                        .height(30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_answers),
                        contentDescription = "",
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "${questionItem.answersCount} answers",
                        style = ExamateTheme.typography.medium12,
                        color = ExamateTheme.color.primary200
                    )
                }
                Text(
                    text = questionItem.date,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 5.dp),
                    style = ExamateTheme.typography.medium12,
                    color = ExamateTheme.color.primary200
                )
            }
        }
    }
}


@Composable
internal fun WritingQuestionsCard(
    questionItem: WritingQuestionsModel
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = ExamateTheme.color.white),
        shape = ExamateTheme.shapes.large,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 7.dp, top = 7.dp, bottom = 7.dp, end = 25.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Surface(
                color = ExamateTheme.color.secondary400,
                shape = ExamateTheme.shapes.small,
                modifier = Modifier
                    .height(15.dp)
            ) {
                Text(
                    text = "${questionItem.answersCount} sur ${questionItem.questionsCount} Questions",
                    style = ExamateTheme.typography.medium12,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center,
                    color = ExamateTheme.color.primary600,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    painter = painterResource(questionItem.icon),
                    contentDescription = "Home",
                    tint = ExamateTheme.color.black,
                    modifier = Modifier
                        .size(18.dp)
                )
                Text(
                    text = questionItem.type,
                    style = ExamateTheme.typography.bold16,
                    textAlign = TextAlign.Start,
                    color = ExamateTheme.color.primary200,
                )
            }
            Text(
                text = "Progress ${questionItem.progress.toInt()} %",
                style = ExamateTheme.typography.medium12,
                textAlign = TextAlign.Center,
                color = ExamateTheme.color.primary200,
            )
            CustomLinearIndicator(
                progress = questionItem.progress,
                modifier = Modifier.fillMaxWidth().padding(7.dp),
            )
        }
    }
}




@Composable
private fun OralQuestionsTextItem(modifier: Modifier = Modifier, titles: List<String>) {
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


