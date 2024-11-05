package com.example.rtandroidtask.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Composable
fun CustomTooltipButton() {
    var isTooltipVisible by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { isTooltipVisible = true }) {
            Text("Hover me!")
        }

        if (isTooltipVisible) {
            Popup(
                onDismissRequest = { isTooltipVisible = false },
                properties = PopupProperties(focusable = false)
            ) {
                Text(
                    "This is a tooltip",
                    modifier = Modifier
                        .background(Color.Black, RoundedCornerShape(4.dp))
                        .padding(8.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
