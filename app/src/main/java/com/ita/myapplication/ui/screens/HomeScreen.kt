package com.ita.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Text(text = "This is the HomeScreen")

        Button(onClick = { navController.navigate("menu") }) {
            Text(text = "Go to Menu")
        }
        Button(onClick = { navController.navigate("components") }) {
            Text(text = "Go to components")
        }
    }
}

