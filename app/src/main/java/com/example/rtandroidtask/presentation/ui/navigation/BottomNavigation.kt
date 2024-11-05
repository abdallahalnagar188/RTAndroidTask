package com.example.rtandroidtask.presentation.ui.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rtandroidtask.R

@Composable
fun MyBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Connect,
        BottomNavItem.Questions,
        BottomNavItem.Tools,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.Gray,
        modifier = Modifier.systemBarsPadding()  // Use 55.sdp if desired scaling
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val isSelected = currentRoute == item.screenRoute

            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        modifier = Modifier
                            .padding(top = if (isSelected) 4.dp else 6.dp)  // Use sdp values
                            .size(if (isSelected) 30.dp else 24.dp),  // Scalable icon sizes
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = if (isSelected) 12.sp else 10.sp,  // Scalable font sizes using ssp
                        maxLines = 1,
                        modifier = Modifier.padding(bottom = if (isSelected) 2.dp else 0.dp)  // Adjust using sdp
                    )
                },
                selectedContentColor = colorResource(R.color.green),
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = true,
                selected = isSelected,
                onClick = {
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}





