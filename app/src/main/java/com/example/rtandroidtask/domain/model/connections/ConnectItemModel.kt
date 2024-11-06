package com.example.rtandroidtask.domain.model.connections

import com.example.rtandroidtask.domain.model.connections.UserModel

data class ConnectItemModel(
    val userName: String = "",
    val image: String = "",
    val target: String = "",
    val userInfo: List<UserModel> = listOf(),
    val languages: List<String> = listOf(),
)
