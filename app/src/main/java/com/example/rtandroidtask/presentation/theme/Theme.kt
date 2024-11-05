package com.example.rtandroidtask.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.omarlkhalil.examate.presentation.theme.Dimens
import com.omarlkhalil.examate.presentation.theme.ExamateShapes
import com.omarlkhalil.examate.presentation.theme.shapes

private val localColorScheme = staticCompositionLocalOf { rtThemeColors }
private val localDimens = staticCompositionLocalOf { Dimens() }
private val localTypography = staticCompositionLocalOf { examateTypGraphy }
private val localShapes = staticCompositionLocalOf { shapes }


@Composable
fun RTAndroidTaskTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        localColorScheme provides rtThemeColors,
        localDimens provides Dimens(),
        localTypography provides examateTypGraphy,
        localShapes provides shapes
    ) {
        content()
    }
}

object ExamateTheme {

    val color: RTColor
        @Composable
        get() = localColorScheme.current

    val dimens: Dimens
        @Composable
        @ReadOnlyComposable
        get() = localDimens.current

    val typography: ExamateTypGraphy
        @Composable
        @ReadOnlyComposable
        get() = localTypography.current

    val shapes: ExamateShapes
        @Composable
        @ReadOnlyComposable
        get() = localShapes.current
}
