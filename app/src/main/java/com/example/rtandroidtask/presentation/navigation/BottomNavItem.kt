package com.example.rtandroidtask.presentation.navigation

import com.example.rtandroidtask.R


sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {
    data object Home : BottomNavItem("Home", R.drawable.home, "home")
    data object Connect : BottomNavItem("Connect", R.drawable.ic_chat, "connect")
    data object Questions : BottomNavItem("Questions", R.drawable.ic_questions, "questions")
    data object Tools : BottomNavItem("Tools", R.drawable.ic_tools, "tools")
    data object Profile : BottomNavItem("Profile", R.drawable.ic_profile, "profile")
}


