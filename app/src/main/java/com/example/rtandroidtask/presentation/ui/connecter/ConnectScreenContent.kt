package com.example.rtandroidtask.presentation.ui.connecter

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rtandroidtask.R
import com.example.rtandroidtask.data.models.ConnectItemModel
import com.example.rtandroidtask.data.models.UserModel
import com.example.rtandroidtask.presentation.theme.ExamateTheme
import com.example.rtandroidtask.presentation.ui.common.MyAppBar
import com.example.rtandroidtask.presentation.ui.common.ScreenContainer

@Composable
fun ConnectScreenContent() {
    ScreenContainer {
        Column(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize()
                .padding(start = 10.dp, bottom = 55.dp, end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MyAppBar(title = "Connect", visible = false)
            Spacer(modifier = Modifier.height(10.dp))
            Tabs()
        }
    }

}

@Composable
fun Tabs() {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf(stringResource(R.string.suggestions), stringResource(R.string.chat))

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
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> Suggestions()
            1 -> Chat()
        }
    }
}


@Composable
fun Suggestions() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Suggested Study Partners",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.weight(1f),
                    style = ExamateTheme.typography.bold18,
                    color = ExamateTheme.color.primary600
                )
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_filters),
                        contentDescription = "Home",
                        tint = ExamateTheme.color.primary400,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }
        }
        items(connectionsList) {
            ConnectCardItem(it)
        }
    }
}

@Composable
fun Chat() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(connectionsList) {
            ConnectCardItem(it)
        }
    }
}


val connectionsList = listOf(
    ConnectItemModel(
        userName = "Gad Alnagar",
        image = "https://randomuser.me/api/portraits/men/66.jpg",
        target = "C1",
        userInfo = listOf(
            UserModel("Mansura", Icons.Outlined.LocationOn),
            UserModel("Male", Icons.Outlined.Person),
            UserModel("22", Icons.Outlined.DateRange),
            UserModel("12/12/2021", Icons.Outlined.DateRange)
        ),
        languages = listOf("Arabic", "Franch")
    ),
    ConnectItemModel(
        userName = "Aly Alnagar",
        image = "https://randomuser.me/api/portraits/men/67.jpg",
        target = "B2",
        userInfo = listOf(
            UserModel("Alexandria", Icons.Outlined.LocationOn),
            UserModel("Male", Icons.Outlined.Person),
            UserModel("30", Icons.Outlined.DateRange),
            UserModel("10/10/2020", Icons.Outlined.DateRange)
        ),
        languages = listOf("Arabic", "French")
    ),
    ConnectItemModel(
        userName = "Sara Alnagar",
        image = "https://randomuser.me/api/portraits/women/60.jpg",
        target = "C1",
        userInfo = listOf(
            UserModel("Giza", Icons.Outlined.LocationOn),
            UserModel("Female", Icons.Outlined.Person),
            UserModel("24", Icons.Outlined.DateRange),
            UserModel("05/05/2019", Icons.Outlined.DateRange)
        ),
        languages = listOf("Arabic", "English", "Spanish")
    ),
    ConnectItemModel(
        userName = "Mo Alnagar",
        image = "https://randomuser.me/api/portraits/men/70.jpg",
        target = "B1",
        userInfo = listOf(
            UserModel("New York", Icons.Outlined.LocationOn),
            UserModel("Male", Icons.Outlined.Person),
            UserModel("35", Icons.Outlined.DateRange),
            UserModel("01/01/2020", Icons.Outlined.DateRange)
        ),
        languages = listOf("English", "Spanish")
    ),
    ConnectItemModel(
        userName = "Nora Alnagar",
        image = "https://randomuser.me/api/portraits/women/27.jpg",
        target = "C2",
        userInfo = listOf(
            UserModel("Florida", Icons.Outlined.LocationOn),
            UserModel("Female", Icons.Outlined.Person),
            UserModel("29", Icons.Outlined.DateRange),
            UserModel("02/02/2021", Icons.Outlined.DateRange)
        ),
        languages = listOf("English", "French")
    )
)