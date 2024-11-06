package com.example.rtandroidtask.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomCircularProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    trackColor: Color = Color.Gray,
    progressColor: Color = Color.Blue,
    strokeWidth: Dp = 6.dp,
) {
    Canvas(modifier = modifier) {
        val sweepAngle = 360 * progress

        drawCircle(
            color = trackColor,
            style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
        )

        drawArc(
            color = progressColor,
            startAngle = -90f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
        )
    }
}