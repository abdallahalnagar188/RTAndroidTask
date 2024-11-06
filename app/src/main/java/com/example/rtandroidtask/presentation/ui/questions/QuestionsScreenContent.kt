package com.example.rtandroidtask.presentation.ui.questions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.rtandroidtask.R
import com.example.rtandroidtask.data.models.questionsList
import com.example.rtandroidtask.data.models.writingsList
import com.example.rtandroidtask.presentation.theme.ExamateTheme
import com.example.rtandroidtask.presentation.components.MyAppBar
import com.example.rtandroidtask.presentation.components.ScreenContainer

@Composable
fun QuestionsScreenContent() {
    ScreenContainer {
        Column(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize()
                .padding(start = 10.dp, bottom = 55.dp, end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MyAppBar(title = "Questions", visible = false)
            Spacer(modifier = Modifier.height(16.dp))
            Tabs()
        }
    }
}

@Composable
fun Tabs() {
    var tabIndex by remember { mutableIntStateOf(0) }

    // List of tabs with titles and icon resource IDs
    val tabs = listOf(
        Pair(stringResource(R.string.writing), R.drawable.ic_writing), // Replace with your writing icon
        Pair(stringResource(R.string.oral), R.drawable.ic_oral)         // Replace with your oral icon
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .systemBarsPadding()
            .displayCutoutPadding()
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = ExamateTheme.color.background,
            contentColor = ExamateTheme.color.primary400,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                    color = ExamateTheme.color.primary400
                )
            }
        ) {
            tabs.forEachIndexed { index, tab ->
                val (title, iconRes) = tab
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    modifier = Modifier.height(40.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = title,
                            modifier = Modifier.size(18.dp),
                            tint = if (tabIndex == index) ExamateTheme.color.primary400 else ExamateTheme.color.contentSecondary
                        )
                        Spacer(modifier = Modifier.width(4.dp)) // Add space between icon and title
                        Text(
                            text = title,
                            style = ExamateTheme.typography.medium14, // Customize text style
                            color = if (tabIndex == index) ExamateTheme.color.primary400 else ExamateTheme.color.contentSecondary
                        )
                    }
                }
            }
        }
        when (tabIndex) {
            0 -> Writing()  // Writing tab content
            1 -> Oral()     // Oral tab content
        }
    }
}


@Composable
fun Oral() {
    Column (modifier = Modifier.fillMaxSize()){
//        FilterButton()
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(6.dp),
            contentPadding = PaddingValues(10.dp)
        ) {
            item{
                FilterButton()
            }
            items(questionsList) {
                OralQuestionsCard(it)
            }
        }
    }

}

@Composable
fun Writing() {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            modifier = Modifier,
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(writingsList.size) { index ->
                WritingQuestionsCard(writingsList[index])
            }
        }
    }

}

@Composable
fun FilterButton() {
    Button(
        onClick = { /* Add your filter action here */ },
        modifier = Modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = ExamateTheme.color.secondary400,
            contentColor = ExamateTheme.color.primary600
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
        shape = RoundedCornerShape(10)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Filter",
                style = ExamateTheme.typography.medium18, // Adjust text size to match the look
            )
            Icon(
                painter = painterResource(R.drawable.ic_filters), // Replace with your filter icon
                contentDescription = "Filter",
                modifier = Modifier
                    .size(24.dp)
                    .padding(start = 4.dp)
            )
        }
    }
}