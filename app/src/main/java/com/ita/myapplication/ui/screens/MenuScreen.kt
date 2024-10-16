package com.ita.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


import androidx.compose.ui.graphics.vector.ImageVector

data class MenuModel(
    val id: Int,
    val title: String,
    val option: String,
    val icon: ImageVector
){

}