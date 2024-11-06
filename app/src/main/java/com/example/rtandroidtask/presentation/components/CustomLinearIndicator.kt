package com.example.rtandroidtask.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.rtandroidtask.presentation.theme.ExamateTheme

@Composable
 fun CustomLinearIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    trackColor: Color = ExamateTheme.color.secondary200,
    progressColor: Color = ExamateTheme.color.primary400,
    strokeWidth: Dp = 6.dp,
) {
    val normalizedProgress = (progress.coerceIn(0f, 100f)) / 100f

    Canvas(modifier = modifier.height(strokeWidth)) {
        val width = size.width
        val height = size.height

        drawLine(
            color = trackColor,
            start = Offset(0f, height / 2),
            end = Offset(width, height / 2),
            strokeWidth = height,
            cap = StrokeCap.Round
        )

        drawLine(
            color = progressColor,
            start = Offset(0f, height / 2),
            end = Offset(width * normalizedProgress, height / 2),
            strokeWidth = height,
            cap = StrokeCap.Round
        )
    }
}