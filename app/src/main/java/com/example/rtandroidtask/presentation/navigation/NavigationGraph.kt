package com.example.rtandroidtask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rtandroidtask.presentation.ui.home.HomeScreen
import com.example.rtandroidtask.presentation.ui.connecter.ConnectScreen
import com.example.rtandroidtask.presentation.ui.profile.ProfileScreen
import com.example.rtandroidtask.presentation.ui.questions.QuestionsScreen
import com.example.rtandroidtask.presentation.ui.tools.ToolsScreen


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.screenRoute
    ) {
        composable(BottomNavItem.Home.screenRoute) {
            HomeScreen(navController)
        }
        composable(BottomNavItem.Connect.screenRoute) {
            ConnectScreen(navController)
        }
        composable(BottomNavItem.Questions.screenRoute) {
            QuestionsScreen(navController)
        }
        composable(BottomNavItem.Tools.screenRoute) {
            ToolsScreen(navController)
        }
        composable(BottomNavItem.Profile.screenRoute) {
            ProfileScreen(navController)
        }

    }

}