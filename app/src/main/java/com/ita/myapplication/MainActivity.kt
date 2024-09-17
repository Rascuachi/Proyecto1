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
import com.ita.myapplication.ui.screens.MenuScreen
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.compose.material3.Surface
import com.ita.myapplication.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //se crea interfaz
        super.onCreate(savedInstanceState)
        setContent{
            ComposableMultiScreenApp()
        }//end setContent
    }//end ComponentACtivity
}//end MainActivity

@Composable
fun ComposableMultiScreenApp(){
    val navController = rememberNavController()/*
    objeto navController, transisión entre pantallas
    */
    Surface(//dibujar en pantalla
        modifier = Modifier.fillMaxSize(),//ocupa toda la pantalla
        color = Color.White
    ) {
        SetupNavGraph(navController = navController) /*
        pasa navController como argumento hacia la función SetupNavGraph
        */
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
    }
}
