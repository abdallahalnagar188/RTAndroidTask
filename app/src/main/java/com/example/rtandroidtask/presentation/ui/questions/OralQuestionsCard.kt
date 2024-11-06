package com.example.rtandroidtask.presentation.ui.questions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rtandroidtask.R
import com.example.rtandroidtask.data.models.OralQuestionsModel
import com.example.rtandroidtask.presentation.theme.ExamateTheme

@Composable
internal fun OralQuestionsCard(
    questionItem: OralQuestionsModel
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = ExamateTheme.color.white),
        shape = ExamateTheme.shapes.large,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp),
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