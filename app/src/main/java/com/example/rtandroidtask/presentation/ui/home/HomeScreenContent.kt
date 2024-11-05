package com.example.rtandroidtask.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rtandroidtask.R
import com.example.rtandroidtask.presentation.ui.common.MyAppBar
import com.example.rtandroidtask.presentation.ui.common.ScreenContainer

@Composable
fun HomeScreenContent() {
    ScreenContainer {
        Column(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize()
                .padding(start = 10.dp, bottom = 55.dp, end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MyAppBar(title = "Home", visible = true)
            Spacer(modifier = Modifier.height(10.dp))
            HelloTextTile(title = "Abdallah Alnagar")
            Spacer(modifier = Modifier.height(20.dp))
            ProgressSteps()
        }
    }

}
