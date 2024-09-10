package com.ita.myapplication

import androidx.compose.material3.Icon
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment =  androidx.compose.ui.Alignment.CenterHorizontally//contenedor es columna y ocupa espacio max
            ){
//                Text(text = "simple text")
//                ModifierExample()
//                ModifierExample2()
//                ModifierExample3()
                CustomText()
                Picture()
                //Content1()
                Content2()

            }//end Column
        }//end setContent

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

//@Preview(showBackground = true)//etiqueta no se muestra
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column(
        modifier = Modifier //adentro de los parentesis
            .padding(24.dp) //cuadro 24 pixeles
    ){
        Text(text = "Hello World 2")

    }
}

//@Preview(showBackground = true)
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

//@Preview(showBackground = true)
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
@Preview(showBackground = true)
@Composable
fun CustomText(){
    val gradientColors = listOf(Cyan, Blue, Red)
    Column() {
        Text(
            stringResource(R.string.hello_world_text),
            color = colorResource(id = R.color.purple_200),
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
        )
        Text(
            stringResource(R.string.hello_world_text),
            style = TextStyle(Brush.linearGradient(colors = gradientColors))
        )
    }
}

@Preview(showBackground = true)
@Composable

fun Picture(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "Logo Android",
            contentScale = ContentScale.Crop

        )
    }

}

@Preview(showBackground = true)
@Composable
fun Content1(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Text(text = "This is a title",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android logo",
            contentScale = ContentScale.Crop
        )//end Image

        Text(
            stringResource(R.string.text_card) ,
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,
            modifier = Modifier
                .padding(10.dp)
        )//end Text

    }
}//end Content1()

@Preview(showBackground = true)
@Composable
fun Content2(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            // Imagen a la izquierda
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android logo",
                modifier = Modifier
                    .height(100.dp) // Ajusta el tamaño si es necesario
                    .width(100.dp),
                contentScale = ContentScale.Crop
            )

            // Texto a la derecha de la imagen
            Column(
                modifier = Modifier
                    .padding(start = 10.dp) // Espacio entre la imagen y el texto
            ) {
                // Título
                Text(
                    text = "Amor a mapache",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )

                // Texto "te quiero mapache"
                Text(
                    text = "Te quiero mapache",
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxExample1() {
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize() // Ajustar la imagen para que llene el contenedor
        )

        // Ajustamos el Row dentro del Box
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp,150.dp),
            horizontalArrangement = Arrangement.Center

        )
        {
            // Ícono
            Icon(
                Icons.Filled.AccountBox,
                contentDescription = "Icon"
            )


            // Texto
            Text(text = "Text",
//             textAlign = TextAlign.Center,
//             modifier = Modifier
//            .fillMaxWidth()
//            .padding(0.dp,150.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BoxExample2(){
    Box(
        modifier = Modifier
            .background(Color.Magenta)
            .padding(5.dp)
            .size(250.dp)
    ){
        Text(text = "TopStart", Modifier.align(Alignment.TopStart))//izquierda
        Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))//derecha
        Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))//centro
        Text(text = "Center", Modifier.align(Alignment.Center))//centro
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))//centro
        Text(text = "BottomStar", Modifier.align(Alignment.BottomStart))//izquierda
        Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))//derecha
    }
}

