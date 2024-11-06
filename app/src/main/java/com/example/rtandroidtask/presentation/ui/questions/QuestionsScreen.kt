package com.example.rtandroidtask.presentation.ui.questions

import android.os.Handler
import android.os.Looper
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rtandroidtask.R
import com.example.rtandroidtask.data.models.questionsList
import com.example.rtandroidtask.data.models.writingsList
import com.example.rtandroidtask.presentation.components.ToolTipItem
import com.example.rtandroidtask.presentation.theme.ExamateTheme
import com.example.rtandroidtask.presentation.components.ScreenContainer
import com.example.rtandroidtask.presentation.viewmodel.SharedViewModel
import com.example.rtandroidtask.presentation.components.OralQuestionsCard
import com.example.rtandroidtask.presentation.components.ToolTipHintItem


@Composable
internal fun QuestionsScreen(
    questionState: QuestionScreenHintState,
    viewModel: SharedViewModel = hiltViewModel()
) {
    val visibleHintCoordinates = remember { mutableStateOf(viewModel.visibleHintCoordinates.value) }
    ScreenContainer {
        QuestionsTabs(questionState, visibleHintCoordinates, viewModel)
    }
}

@Composable
internal fun QuestionsTabs(
    questionState: QuestionScreenHintState,
    visibleHintCoordinates: MutableState<LayoutCoordinates?>,
    viewModel: SharedViewModel
) {
    val tabIndex by viewModel.questionsTabsIndex.collectAsState()
    val tabs = listOf(stringResource(R.string.writing), stringResource(R.string.oral))

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            modifier = Modifier.width(240.dp),
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
                Tab(text = {
                    Row(
                        verticalAlignment = CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        if (index == 0) {
                            Icon(
                                painter = painterResource(R.drawable.ic_writing),
                                modifier = Modifier.size(18.dp),
                                tint = ExamateTheme.color.primary400,
                                contentDescription = ""
                            )
                        } else {
                            Icon(
                                painter = painterResource(R.drawable.ic_oral),
                                modifier = Modifier.size(18.dp),
                                tint = ExamateTheme.color.primary400,
                                contentDescription = ""
                            )
                        }
                        Text(
                            title,
                            style = ExamateTheme.typography.bold16,
                            color = ExamateTheme.color.primary400
                        )
                    }
                },
                    selected = tabIndex == index,
                    onClick = { viewModel.setTabsIndex(index) }
                )
            }
        }
        when (tabIndex) {
            0 -> Writing(
                questionState,
                visibleHintCoordinates
            )

            1 -> Oral(
                questionState,
                visibleHintCoordinates,
                viewModel
            )
        }
    }
}

@Composable
internal fun Oral(
    questionsState: QuestionScreenHintState,
    visibleHintCoordinates: MutableState<LayoutCoordinates?>,
    viewModel: SharedViewModel
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        item {
            if (questionsState.isFilterHintVisible.value) {
                ToolTipHintItem(
                    iconRes = R.drawable.ic_filters,
                    textRes = R.string.home,
                    isHintVisible = questionsState.isFilterHintVisible,
                    visibleHintCoordinates = visibleHintCoordinates,
                    onClick = {
                        viewModel.updateSelectedIndex(2)
                    },
                    customContent = {
                        Row(
                            modifier = Modifier
                                .clip(ExamateTheme.shapes.small)
                                .width(100.dp)
                                .height(40.dp)
                                .background(ExamateTheme.color.secondary400),
                            verticalAlignment = CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Filter",
                                textAlign = TextAlign.Start,
                                style = ExamateTheme.typography.bold16,
                                color = ExamateTheme.color.primary600
                            )
                            Icon(
                                painter = painterResource(R.drawable.ic_filters),
                                contentDescription = "Filter",
                                tint = ExamateTheme.color.primary400,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    },
                    customHintContent = {
                        ToolTipItem(
                            hintText = stringResource(R.string.hint),
                            isHintVisible = questionsState.isFilterHintVisible,
                            onCloseClick = {
                                viewModel.endTutorial()
                            },
                            onNextClick = {
                                questionsState.isFilterHintVisible.value =
                                    !questionsState.isFilterHintVisible.value
                                viewModel.updateSelectedIndex(3)
                                Handler(Looper.getMainLooper()).post{
                                    questionsState.isToolsHintVisible.value =
                                        !questionsState.isToolsHintVisible.value
                                }
                            },
                            icon = R.drawable.ic_filters
                        )
                    }
                )
            } else {
                // Default display without the hint
                Row(
                    modifier = Modifier
                        .clip(ExamateTheme.shapes.small)
                        .width(100.dp)
                        .height(40.dp)
                        .background(ExamateTheme.color.secondary400),
                    verticalAlignment = CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Filter",
                        textAlign = TextAlign.Start,
                        style = ExamateTheme.typography.bold16,
                        color = ExamateTheme.color.primary600
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_filters),
                        contentDescription = "Filter",
                        tint = ExamateTheme.color.primary400,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
        items(questionsList) {

            OralQuestionsCard(it)

        }
    }
}

@Composable
private fun Writing(
    questionScreenHintState: QuestionScreenHintState,
    visibleCoordinates: MutableState<LayoutCoordinates?> = mutableStateOf(null),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {
        CustomTabSample(questionScreenHintState, visibleCoordinates)
    }

}

@Composable
internal fun CustomTabSample(
    questionScreenHintState: QuestionScreenHintState,
    visibleCoordinates: MutableState<LayoutCoordinates?> = mutableStateOf(null),
) {

    val (selected, setSelected) = remember {
        mutableIntStateOf(0)
    }

    CustomTab(
        items = listOf("Task 1", "Task 2"),
        selectedItemIndex = selected,
        modifier = Modifier.padding(horizontal = 10.dp),
        onClick = setSelected,
    )

    when (selected) {
        0 -> QuestionsGridList(questionScreenHintState, visibleCoordinates)
        1 -> QuestionsGridList(questionScreenHintState, visibleCoordinates)
    }
}

@Composable
private fun QuestionsGridList(
    questionScreenHintState: QuestionScreenHintState,
    visibleHintCoordinates: MutableState<LayoutCoordinates?> = mutableStateOf(null),
    viewModel: SharedViewModel = hiltViewModel(),
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(writingsList) {
            if (writingsList.indexOf(it) == 0) {
                ToolTipHintItem(
                    iconRes = R.drawable.ic_filters,
                    textRes = R.string.home,
                    isHintVisible = questionScreenHintState.isFirstItemHintVisible,
                    visibleHintCoordinates = visibleHintCoordinates,
                    onClick = {
                    },
                    customContent = {
                        WritingQuestionsCard(it)
                    },
                    customHintContent = {
                        ToolTipItem(
                            hintText = stringResource(R.string.hint),
                            isHintVisible = questionScreenHintState.isFirstItemHintVisible,
                            onCloseClick = {
                                viewModel.endTutorial()
                            },
                            onNextClick = {
                                questionScreenHintState.isFirstItemHintVisible.value =
                                    !questionScreenHintState.isFirstItemHintVisible.value
                                Handler(Looper.getMainLooper()).postDelayed({
                                    viewModel.setTabsIndex(1)
                                    questionScreenHintState.isFilterHintVisible.value =
                                        !questionScreenHintState.isFilterHintVisible.value
                                }, 500)
                            },
                            icon = R.drawable.ic_filters
                        )
                    }
                )
            } else {
                WritingQuestionsCard(it)
            }
        }
    }
}


@Composable
internal fun CustomTab(
    selectedItemIndex: Int,
    items: List<String>,
    modifier: Modifier = Modifier,
    tabWidth: Dp = 100.dp,
    onClick: (index: Int) -> Unit,
) {
    val indicatorOffset: Dp by animateDpAsState(
        targetValue = tabWidth * selectedItemIndex,
        animationSpec = tween(easing = LinearEasing), label = "",
    )

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(ExamateTheme.color.secondary400)
            .height(intrinsicSize = IntrinsicSize.Min),
    ) {
        MyTabIndicator(
            indicatorWidth = tabWidth,
            indicatorOffset = indicatorOffset,
            indicatorColor = ExamateTheme.color.primary600,
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clip(CircleShape),
        ) {
            items.mapIndexed { index, text ->
                val isSelected = index == selectedItemIndex
                MyTabItem(
                    isSelected = isSelected,
                    onClick = {
                        onClick(index)
                    },
                    tabWidth = tabWidth,
                    text = text,
                )
            }
        }
    }
}

@Composable
private fun MyTabItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    tabWidth: Dp,
    text: String,
) {
    val tabTextColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            White
        } else {
            Black
        },
        animationSpec = tween(easing = LinearEasing), label = "",
    )
    Text(
        modifier = Modifier
            .clip(CircleShape)
            .clickable {
                onClick()
            }
            .width(tabWidth)
            .padding(
                vertical = 8.dp,
                horizontal = 12.dp,
            ),
        text = text,
        color = tabTextColor,
        textAlign = TextAlign.Center,
    )
}

@Composable
private fun MyTabIndicator(
    indicatorWidth: Dp,
    indicatorOffset: Dp,
    indicatorColor: Color,
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(width = indicatorWidth)
            .offset(x = indicatorOffset)
            .clip(shape = CircleShape)
            .background(color = indicatorColor),
    )
}
