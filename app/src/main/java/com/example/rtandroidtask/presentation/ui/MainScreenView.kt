package com.example.rtandroidtask.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.rtandroidtask.presentation.ui.navigation.MyBottomNavigation
import com.example.rtandroidtask.presentation.ui.navigation.NavigationGraph


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { MyBottomNavigation(navController = navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}