package com.example.appcursos.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SetSystemBarsColors(setStatusBarColor: Color, setNavigationBarColor: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        //systemUiController.setSystemBarsColor(color)
        systemUiController.setStatusBarColor(setStatusBarColor)
        systemUiController.setNavigationBarColor(setNavigationBarColor)
    }
}