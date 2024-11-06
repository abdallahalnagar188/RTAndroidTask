package com.example.rtandroidtask.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rtandroidtask.R
import com.example.rtandroidtask.presentation.theme.ExamateTheme
import com.example.rtandroidtask.presentation.ui.navigation.Roots

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BaseTopBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val title = when (currentRoute) {
        Roots.Home.route -> R.string.home
        Roots.Tools.route -> R.string.tools
        Roots.Connect.route -> R.string.connect
        Roots.Profile.route -> R.string.profile
        Roots.Questions.route -> R.string.questions
        else -> R.string.empty
    }

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = ExamateTheme.color.background,
            titleContentColor = ExamateTheme.color.primary800,
        ),
        title = {
            TopBarTitle(title = title)
        },
        actions = {
            if (currentRoute == Roots.Home.route) {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Home",
                        tint = ExamateTheme.color.primary400,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }

            }
        }
    )

}


@Composable
fun TopBarTitle(
    title: Int,
    textStyle: TextStyle = ExamateTheme.typography.bold24,
    textColor: Color = ExamateTheme.color.primary600,
) {
    Text(
        text = stringResource(title),
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth(),
        style = textStyle,
        color = textColor
    )
}