package com.example.rtandroidtask.presentation.ui.questions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rtandroidtask.data.models.WritingQuestionsModel
import com.example.rtandroidtask.presentation.theme.ExamateTheme
import com.example.rtandroidtask.presentation.components.CustomLinearIndicator

@Composable
internal fun WritingQuestionsCard(
    questionItem: WritingQuestionsModel
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = ExamateTheme.color.white),
        //shape = ExamateTheme.shapes.large,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp),
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
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
                    tint = ExamateTheme.color.secondary600,
                    modifier = Modifier
                        .size(22.dp)
                )
                Text(
                    text = questionItem.type,
                    style = ExamateTheme.typography.bold16,
                    textAlign = TextAlign.Start,
                    color = ExamateTheme.color.contentSecondary,
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
