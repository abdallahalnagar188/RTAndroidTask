package com.example.rtandroidtask.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rtandroidtask.presentation.components.ScreenContainer

@Composable
fun HomeScreenContent() {
    ScreenContainer {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding( end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HelloTextTile(title = "Abdallah Alnagar")
            Spacer(modifier = Modifier.height(10.dp))
            ProgressSteps()
        }
    }

}
