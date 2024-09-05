package com.ita.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ita.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //se crea interfaz
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()//Se utiliza el 100 del tamaño de la pantalla
//        setContent {
////            MyApplicationTheme {
////                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> //id de html
////                    Greeting( //funcion
////                        name = "Android",
////                        modifier = Modifier.padding(innerPadding)
////                    )
////                }
////            }
//            //Layouts
//            Column{
//                Text(text = "First Row")
//                Text(text = "Second Row")
//                Text(text = "Third Row")
//                Row{
//                    Text(text = "TEXT 1")
//                    Text(text = "TEXT 2")
//                    Text(text = "TEXT 3")
//                    Text(text = "TEXT 4")
//
//                }
//                Box{//encima los elementos
//                    Text(text = "Label 1")
//                    Text(text = "Label 2")
//
//                }
//                Greeting(name = "World")//componente que mandamos llamar
//            }
//        }
        setContent{
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment =  androidx.compose.ui.Alignment.CenterHorizontally//contenedor es columna y ocupa espacio max
            ){
                Text(text = "simple text")
                ModifierExample()
                ModifierExample2()
                ModifierExample3()

            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {//Funcion
    Text(//texto objeto
        text = "Hello $name!", //"Hello Android"
        modifier = modifier
    )
}
//Todo con composable es un fragmento de diseño

@Preview(showBackground = true)//etiqueta no se muestra
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column(
        modifier = Modifier //adentro de los parentesis
            .padding(24.dp) //cuadro 24 pixeles
    ){
        Text(text = "Hello World 2")

    }
}

@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column(
        modifier = Modifier //adentro de los parentesis
            .padding(24.dp) //cuadro 24 pixeles para separar
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ){
        Text(text = "Hello World 2")

    }
}

//Composable es de diseño

fun clickAction(){//mandar a llamar en main
    println("Column clicked")
}

@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Cyan)
            .border(width = 2.dp, color = Color.Red)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
        Text(text = "Item 5")
    }
}