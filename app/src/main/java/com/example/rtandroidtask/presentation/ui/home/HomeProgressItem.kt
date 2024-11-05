package com.example.rtandroidtask.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.rtandroidtask.R
import com.example.rtandroidtask.presentation.ui.common.CustomCircularProgressIndicator

@Composable
fun HomeProgressItem(
    stepNumber: Int,
    title: String,
    progress: Float = 0f,
    isCompleted: Boolean,
    isLocked: Boolean,
    showLine: Boolean = true
) {
    // Update colors with new resources
    val tintColor = if (!isCompleted) colorResource(R.color.primary_400) else colorResource(R.color.gray)
    val backGroundColor = if (!isCompleted) colorResource(R.color.secondary_400) else colorResource(R.color.primary_200)
    val textColor = if (!isCompleted) colorResource(R.color.primary_400) else colorResource(R.color.content_secondary)
    val adjustedProgress = if (isLocked) 1f else progress
    val trackColor = if (isCompleted) colorResource(R.color.primary_400) else colorResource(R.color.primary_200)

    Column(
        horizontalAlignment = Alignment.Start,

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier.size(90.dp),
                    contentAlignment = Center
                ) {
                    CustomCircularProgressIndicator(
                        progress = adjustedProgress,
                        strokeWidth = 6.dp,
                        trackColor = trackColor,
                        modifier = Modifier.size(85.dp),
                        progressColor = tintColor,
                    )
                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .clip(CircleShape)
                            .border(2.dp, tintColor, CircleShape)
                            .background(backGroundColor),
                        contentAlignment = Center
                    ) {
                        Text(
                            text = stepNumber.toString(),
                            style = MaterialTheme.typography.h5, // Replace with your desired typography
                            color = if (!isCompleted) colorResource(R.color.primary_400) else Color.White
                        )
                    }
                    if (isLocked) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(colorResource(R.color.primary_200))
                                .padding(5.dp)
                                .align(Alignment.BottomEnd)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Lock,
                                contentDescription = "Locked",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
                if (showLine) {
                    Box(
                        modifier = Modifier
                            .width(6.dp)
                            .height(40.dp)
                            .background(backGroundColor)
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                modifier = Modifier.padding(bottom = 26.dp),
                color = textColor,
                style = MaterialTheme.typography.h6
            )
        }
    }
}


