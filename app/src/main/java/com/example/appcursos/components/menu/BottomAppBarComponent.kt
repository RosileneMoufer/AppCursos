package com.example.appcursos.components.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomAppBarComponent(navController : NavController) {
    BottomAppBar(
        actions = {
            IconButton(onClick = { navController.navigate("courses") }) {
                Icon(Icons.Filled.Home, contentDescription = "Localized description")
            }
            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
            IconButton(onClick = { navController.navigate("support") }) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
        },
    )
}