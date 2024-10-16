package com.ita.myapplication.data_model

import androidx.compose.ui.graphics.painter.Painter

data class PostModel(
    //definir info del modelo
    //aqui se define lo de la base de datos
    val id: Int,
    val title: String,
    val text: String,
    val image: Painter
)
