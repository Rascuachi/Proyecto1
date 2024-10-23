package com.ita.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.compose.material3.Surface
import com.ita.myapplication.ui.screens.MenuScreen
import com.ita.myapplication.ui.screens.ComponentsScreen
import com.ita.myapplication.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableMultiScreenApp()
        }
    }
}

@Composable
fun ComposableMultiScreenApp() {
    val navController = rememberNavController() // Objeto navController para manejar la navegación
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("menu") {
            MenuScreen(navController)
        }
        composable("components") {
            ComponentsScreen(navController)
        }
    }
}
