package com.example.rtandroidtask.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rtandroidtask.R

@Composable
fun MyAppBar(
    title: String,
    icon: Int = R.drawable.ic_notification,
    visible: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 12.dp)
            .displayCutoutPadding()
            .systemBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        Text(
            text = title,
            fontSize = 30.sp,
            textAlign = TextAlign.Start,
            fontWeight = MaterialTheme.typography.h6.fontWeight,
            color = colorResource(id = R.color.teal_700),
            fontFamily = fontBold
        )

        if (visible) {
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(45.dp)
                    .padding(end = 12.dp)
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "Notification Icon",
                    tint = colorResource(id = R.color.teal_700),
                    modifier = Modifier.size(45.dp)
                )
            }
        }
    }
}
