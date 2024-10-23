package com.ita.myapplication.ui.screens

import android.widget.ArrayAdapter
import android.widget.CheckedTextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem // Asegúrate de que este import está presente
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TimePicker
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.ita.myapplication.R
import com.ita.myapplication.data_model.MenuModels
import com.ita.myapplication.data_model.PostModel
import com.ita.myapplication.ui.components.PostCard
import com.ita.myapplication.ui.components.PostCardCompact
import java.util.Calendar

@Composable
fun ComponentsScreen(navController: NavController) {
    var menuOptions = arrayOf(
        MenuModels(1,"Content 1","Content1",Icons.Filled.Home),
        MenuModels(2,"Content 2","Content2",Icons.Filled.Person),
        MenuModels(3,"Buttons","Buttons",Icons.Filled.Build),
        MenuModels(4,"Floating Buttons","FloatingButtons",Icons.Filled.AddCircle),
        MenuModels(5,"Chips","Chips",Icons.Filled.Info),
        MenuModels(6,"Progress","Progress",Icons.Filled.Check),
        MenuModels(7,"Sliders","Sliders",Icons.Filled.Favorite),
        MenuModels(8,"Switches","Switches",Icons.Filled.Home),
        MenuModels(9,"Badges","Badges",Icons.Filled.ShoppingCart),
        MenuModels(10,"TimePickers","TimePickers",Icons.Filled.Notifications),
        MenuModels(11,"DatePickers","DatePickers",Icons.Filled.DateRange),
        MenuModels(12,"AlertDialogs","AlertDialogs",Icons.Filled.Warning),
        MenuModels(13,"SnackBars","SnackBars",Icons.Filled.Settings),
        MenuModels(14,"Bars","Bars",Icons.Filled.Person),
        MenuModels(15,"Adaptive","Adaptive",Icons.Filled.Warning)

    )

    var component by rememberSaveable{ mutableStateOf("") } //Can assign a value
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(

        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()

                LazyColumn {
                    items(menuOptions) { item ->
                        NavigationDrawerItem(
                            icon = { Icon(item.icon, contentDescription = null) },
                            label = { Text(item.title) },
                            selected = false,
                            onClick = {
                                component = item.option
                                scope.launch {
                                    drawerState.apply {
                                        close() // Close drawer or side menu
                                    }
                                }
                            }
                        )
                    }
                }


//                //Content1
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "Content1")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "Content1"
//                        scope.launch {
//                            drawerState.close() // Uso correcto para cerrar el Drawer
//                        }
//                    }
//                )//end NavigationDrawerItem
//
//                //Content2
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "Contenido2")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "Content2"
//                        scope.launch {
//                            drawerState.close() // Uso correcto para cerrar el Drawer
//                        }
//                    }
//                )
//
//                //FloatingAction
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "Floating Buttons")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "floating-buttons"
//                        scope.launch {
//                            drawerState.close() // Uso correcto para cerrar el Drawer
//                        }
//                    }
//                )
//
//                //Chips
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "Chips")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "chips"
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    }
//                )
//
//                //Progress
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "Progress")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "progress"
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    }
//                )
//
//                //Sliders
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "Sliders")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "sliders"
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    }
//                )
//
//                //Switches
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "Switches")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "switches"
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    }
//                )
//                //Badges
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "Badges")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "badges"
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    }
//                )
//                //DatePickers
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "DatePickers")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "date-pickers"
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    }
//                )
//                //TimePickers
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "TimePickers")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "time-pickers"
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    }
//                )
//                //SnackBars
//                NavigationDrawerItem(
//                    label = {
//                        Text(text = "TimePickers")
//                    },
//                    selected = false,
//                    onClick = {
//                        component = "time-pickers"
//                        scope.launch {
//                            drawerState.close()
//                        }
//                    }
//                )


            }//end ModelDrawerSheet
        }//drawerContent
    ) {

        Column {
            when(component){//switchcasse
                "Content1" -> {
                    Content1()
                }
                "Content2" ->{
                    Content2()
                }
                "Buttons" ->{
                    Buttons()
                }
                "Floating" ->{
                    FloatingButtons()
                }
                "Chips" ->{
                    Chips()
                }
                "Progress"->{
                    Progress()
                }
                "Sliders"->{
                    Sliders()
                }
                "Switches"->{
                    Switches()
                }
                "Badges"->{
                    Badges()
                }
                "TimePickers" ->{
                    TimePickers()
                }
                "DatePickers"->{
                    DatePickers()
                }
                "AlertDialogs"->{ //Notify the user a task done
                    AlterDialogs()
                }
                "SnackBars"->{ //A dialog prompt to confirm
                    SnackBars()
                }
                "Bars"->{
                    Bars()
                }
                "Adaptive"->{
                    Adaptive()
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

//@Preview(showBackground = true)
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

        InputChipExample("Dismiss",{})

    }
}//end Chips

@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit,

){
    var enabled by remember { mutableStateOf(true)}
    if(!enabled) return
    InputChip(
        label = {Text(text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },

        trailingIcon = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }

    )
}

//@Preview(showBackground = true)
@Composable
fun Progress( ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Sliders( ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var sliderPosition by remember{mutableStateOf(50f)}
        Column {
            Slider(
                value = sliderPosition,
                onValueChange = {sliderPosition = it},
                steps = 10,
                valueRange = 0f..100f
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                text = sliderPosition.toString()
            )
        }

    }
}

//@Preview(showBackground = true)
@Composable
fun Switches( ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        var checked by remember { mutableStateOf(true)}
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
        var checked2 by remember { mutableStateOf(true)}
        Switch(
            checked = checked2,
            onCheckedChange = {
                checked2 = it
            },
            thumbContent = if(checked2){
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }else{
                null
            }

        )
        var checked3 by remember { mutableStateOf(true)}
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3 = it}
        )

    }
}

//@Preview(showBackground = true)
@Composable
fun Badges( ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var itemCount by remember { mutableStateOf(0)}
        BadgedBox(
            badge = {
                if(itemCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White

                    ){
                        Text("$itemCount")
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = ""
            )
        }
        Button(
            onClick = {itemCount++}
        ){
            Text("Add item")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun DatePickers() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        var showDatePicker by remember { mutableStateOf(false) }
        val datePickerState = rememberDatePickerState()
        val selectedDate = datePickerState.selectedDateMillis?.let {
            convertMillisToDate(it)
        } ?: ""

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = selectedDate,
                onValueChange = { },
                label = { Text("DOB") },
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { showDatePicker = !showDatePicker }) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Select date"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            )

            if (showDatePicker) {
                Popup(
                    onDismissRequest = { showDatePicker = false },
                    alignment = Alignment.TopStart
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 64.dp)
                            .shadow(elevation = 4.dp)
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(16.dp)
                    ) {
                        DatePicker(
                            state = datePickerState,
                            showModeToggle = false
                        )
                    }
                }
            }
        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun TimePickers() {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    var selectedTime by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        TimePicker(
            state = timePickerState,
        )

        // Botón para descartar el TimePicker
        Button(onClick = {
            selectedTime = "Selection dismissed"
        }) {
            Text("Dismiss picker")
        }

        // Botón para confirmar la selección de hora
        Button(onClick = {
            val selectedHour = timePickerState.hour
            val selectedMinute = timePickerState.minute
            selectedTime = "Selected time: %02d:%02d".format(selectedHour, selectedMinute)
        }) {
            Text("Confirm selection")
        }

        // Mostrar la hora seleccionada
        Text(text = selectedTime)
    }
}


//@Preview(showBackground = true)
@Composable
fun SnackBars() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        // SnackbarHost para mostrar la Snackbar
        SnackbarHost(hostState = snackState, modifier = Modifier)

        // Función para mostrar la Snackbar
        fun launchSnackBars() {
            snackScope.launch {
                snackState.showSnackbar("The message was sent")
            }
        }

        // Botón para disparar la función
        Button(onClick = { launchSnackBars() }) {
            Text("Show Snackbar")
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun AlterDialogs() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        var showAlterDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if (showAlterDialog) {
            AlertDialog(
                icon = { Icon(Icons.Filled.Warning, contentDescription = null) },
                title = { Text(text = "Confirm deletion") },
                text = { Text(text = "Are you sure you want to delete the file?") },
                onDismissRequest = {
                    // Si el diálogo es cerrado sin seleccionar una opción
                    showAlterDialog = false
                },
                confirmButton = {
                    TextButton(onClick = {
                        selectedOption = "Confirm"
                        showAlterDialog = false
                    }) {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        selectedOption = "Dismiss"
                        showAlterDialog = false
                    }) {
                        Text(text = "Dismiss")
                    }
                }
            )
        }

        Text(selectedOption)

        Button(onClick = { showAlterDialog = true }) {
            Text("Show alert dialog")
        }
    }
}

@Composable
fun Bars(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)
    ){
        Row (
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .background(Color.Black)
                .padding(10.dp, 50.dp, 10.dp, 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(Icons.Filled.Menu,
                contentDescription = "",
                tint = Color.White)
            Text(text = "App Title",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
            Icon(Icons.Filled.Settings,
                contentDescription = "",
                tint = Color.White)
        }
        var post = arrayOf(
            PostModel(1,"Title 1","Text 1", painterResource(R.drawable.android_logo)),
            PostModel(2,"Title 2","Text 2", painterResource(R.drawable.android_logo)),
            PostModel(3,"Title 3","Text 3", painterResource(R.drawable.android_logo)),
            PostModel(4,"Title 4","Text 4", painterResource(R.drawable.android_logo)),
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(10.dp, 90.dp, 10.dp, 50.dp)
                .fillMaxSize()
        ) {
            //Posts(post)
            //PostCard(1,"This is a card title","This is a card text", painterResource(R.drawable.android_logo))
            PostGrid(post)
        }

        Row( //Bottom Nav Bar
            modifier= Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.Black)
                .height(60.dp)
                .padding(2.dp, 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){ //Bottom Bar
            /**
             * Icons on the bottom nav bar
             */
            Column{
                IconButton(onClick={}, modifier = Modifier.size(30.dp)){
                    Icon(Icons.Outlined.Search,
                        contentDescription="",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text("Search", color=Color.White)
            }
            Column{
                IconButton(onClick={}, modifier = Modifier.size(30.dp)){
                    Icon(Icons.Outlined.Menu,
                        contentDescription="",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text("Men", color=Color.White)
            }
            Column{
                IconButton(onClick={}, modifier = Modifier.size(30.dp)){
                    Icon(Icons.Outlined.Home,
                        contentDescription="",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text("Home", color=Color.White)
            }
            Column{
                IconButton(onClick={}, modifier = Modifier.size(30.dp)){
                    Icon(Icons.Outlined.Settings,
                        contentDescription="",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text("Settings", color=Color.White)
            }
        }
    }
}


@Composable
fun Post(arrayPosts:Array<PostModel>, adaptive: String){//recibe array de tipo PostModel; modelo en especifico
    LazyColumn(//espera a una transacción
        //este remplaza al column de arriba
        modifier = Modifier
            .fillMaxSize()

    ){
        items(arrayPosts){//foreach php recorre los elementos de la lista
            post->
            when(adaptive) {
                "PhoneP" -> {
                    PostCardCompact(post.id, post.title, post.text, post.image)
                }
                "PhoneL" -> {
                    PostCard(post.id, post.title, post.text, post.image)
                }
            }
        }
    }
}
@Composable
fun PostGrid(arrayPosts: Array<PostModel>){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = Modifier
            .fillMaxSize()

    ){
        items(arrayPosts){
                post->
            PostCard(post.id, post.title, post.text, post.image)
        }
    }
}
@Preview(showBackground = true, device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
fun Adaptive(){
    var WindowsSize = currentWindowAdaptiveInfo().windowSizeClass
    //Text(text = WindowsSize.toString())

    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass

    //Compact width < 600dp Phone protrait
    //Medium width >= 600dp < 840dp Tablets portrait
    //Expanded width >840dp Tablet landscape

    //Compact height < 480dp Phone Language
    //Medium height >= 480dp < 900dp Tablet in portrait
    var post = arrayOf(
        PostModel(1,"Title 1","Text 1", painterResource(R.drawable.android_logo)),
        PostModel(2,"Title 2","Text 2", painterResource(R.drawable.android_logo)),
        PostModel(3,"Title 3","Text 3", painterResource(R.drawable.android_logo)),
        PostModel(4,"Title 4","Text 4", painterResource(R.drawable.android_logo)),
    )
    if(width == WindowWidthSizeClass.COMPACT){
        Post(post, "PhoneP")
    }else if(height == WindowHeightSizeClass.COMPACT){
        Post(post, "PhoneL")
    }else{
        Post(post, "PhoneL")
    }
}