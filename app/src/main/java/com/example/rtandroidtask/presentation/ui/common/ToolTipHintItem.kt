package com.example.rtandroidtask.presentation.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.yml.tooltip.ToolTipView
import com.example.rtandroidtask.presentation.theme.ExamateTheme


@Composable
internal fun ToolTipHintItem(
    iconRes: Int,
    textRes: Int,
    isHintVisible: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    visibleHintCoordinates: MutableState<LayoutCoordinates?>,
    customHintContent: (@Composable (RowScope) -> Unit)? = null,
    customContent: (@Composable () -> Unit)? = null,
) {
    val tintColor = if(isHintVisible.value) ExamateTheme.color.primary400 else ExamateTheme.color.contentSecondary

    ToolTipView(
        visibleHintCoordinates = visibleHintCoordinates,
        isHintVisible = isHintVisible,
        dismissOnTouchOutside = false,
        hintBackgroundColor = ExamateTheme.color.secondary800,
        modifier = modifier,
        onClick = onClick,
        horizontalPadding = 10.dp,
        customHintContent = customHintContent,
        customViewClickable = {
            if(customContent != null){
                customContent()
            }else {
                Column(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .clip(ExamateTheme.shapes.large)
                        .width(60.dp)
                        .height(70.dp),
                    horizontalAlignment = CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(iconRes),
                        modifier = Modifier.size(24.dp),
                        contentDescription = stringResource(textRes),
                        tint = tintColor,
                    )
                    Spacer(modifier = Modifier.size(ExamateTheme.dimens.space4))
                    Text(
                        text = stringResource(textRes),
                        style = ExamateTheme.typography.medium14,
                        maxLines = 1,
                        color = tintColor
                    )
                }
            }
        }
    )
}