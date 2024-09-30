package com.ita.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem // Asegúrate de que este import está presente
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun ComponentsScreen(navController: NavController) {
    var component by remember { mutableStateOf("") } // actualizar variable interfaz
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(

        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()

                //Content1
                NavigationDrawerItem(
                    label = {
                        Text(text = "Contenido1")
                    },
                    selected = false,
                    onClick = {
                        component = "Content1"
                        scope.launch {
                            drawerState.close() // Uso correcto para cerrar el Drawer
                        }
                    }
                )//end NavigationDrawerItem

                //Content2
                NavigationDrawerItem(
                    label = {
                        Text(text = "Contenido2")
                    },
                    selected = false,
                    onClick = {
                        component = "Content2"
                        scope.launch {
                            drawerState.close() // Uso correcto para cerrar el Drawer
                        }
                    }
                )//end NavigationDrawerItem

                //FloatingAction
                NavigationDrawerItem(
                    label = {
                        Text(text = "Floating Buttons")
                    },
                    selected = false,
                    onClick = {
                        component = "floating-buttons"
                        scope.launch {
                            drawerState.close() // Uso correcto para cerrar el Drawer
                        }
                    }
                )//end NavigationDrawerItem

                //Chips
                NavigationDrawerItem(
                    label = {
                        Text(text = "Chips")
                    },
                    selected = false,
                    onClick = {
                        component = "chips"
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )//end NavigationDrawerItem

            }//end ModelDrawerSheet
        }//drawerContent
    ) {

        Column {
            when(component){//switchcasse
                "Content1"->{
                    Content1()
                }
                "Content2"->{
                    Content2()
                }
                "floating-buttons"->{
                    FloatingButtons()
                }
                "chips"->{
                    FloatingButtons()
                }
            }
        }//end Column

    }
}

@Composable
fun Content1() {
    Text(text = "Content1")
}

@Composable
fun Content2() {
    Text(text = "Content2")
}
@Composable
fun Buttons(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        Button(
            onClick = {}
        ){
            Text(text = "Filled")
        }

        FilledTonalButton(
            onClick = {}
        ){
            Text(text = "Tonal")
        }

        OutlinedButton(
            onClick = {}
        ){
            Text(text = "Outlined")
        }

        ElevatedButton(
            onClick = {}
        ){
            Text(text = "Elevated")
        }

        TextButton(
            onClick = {}
        ){
            Text(text = "Text")
        }

    }
}
//@Preview(showBackground = true)
@Composable
fun FloatingButtons( ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "")
        }

        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "")
        }

        LargeFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "")
        }
        ExtendedFloatingActionButton(
            onClick = {},
            icon =  {Icon(Icons.Filled.Add, "")},
            text = {Text(text = "Extended FAB")}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Chips( ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        AssistChip(
            onClick = {},
            label = { Text(text = "Assist Chip")},
            leadingIcon = {
                Icon(Icons.Filled.AccountBox, "",
                    Modifier.size(AssistChipDefaults.IconSize))
            }
        )//end AssistChip

        var selected by remember { mutableStateOf(false)}

        FilterChip(

            selected = selected,
            onClick = {},
            label = { Text(text = "Filter Chip")},
            leadingIcon = if(selected){
                {
                    Icon(
                        Icons.Filled.AccountBox, "",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )//end Icon
                }
            }else{
                null
            }

        )//end FilterChip

    }
}//end Chips