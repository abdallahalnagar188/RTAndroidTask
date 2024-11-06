package com.example.rtandroidtask.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rtandroidtask.R
import com.example.rtandroidtask.presentation.components.fontBold
import com.example.rtandroidtask.presentation.components.fontMedium

@Composable
fun HelloTextTile(
    title: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ){
        Text(
            text = stringResource(R.string.hi),
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            fontFamily = fontMedium,
            fontWeight = MaterialTheme.typography.h1.fontWeight,
            color = colorResource(id = R.color.primary_800),
            modifier = Modifier.padding(end = 3.dp)

        )
        Text(
            text = title,
            textAlign = TextAlign.Start,
            fontSize = 22.sp,
            fontWeight = MaterialTheme.typography.h2.fontWeight,
            color = colorResource(id = R.color.primary_800),
            fontFamily = fontBold,
            modifier = Modifier.padding(end = 3.dp)
        )
    }

}