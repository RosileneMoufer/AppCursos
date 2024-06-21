package com.example.appcursos.components.menu

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

class ItemNavigationBar(val nome:String, val icon:ImageVector, val action: ()->Unit)

@Composable
fun BottomAppBarComponent(itens: List<ItemNavigationBar>) {
    /*
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

     */

    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar(containerColor = Color.White, contentColor = Color(0xFF5DB075)) {
        itens.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.nome) },
                label = { Text(item.nome) },
                selected = selectedItem == index,
                onClick = { selectedItem = index; item.action() },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF5DB075),
                    selectedTextColor = Color(0xFF5DB075),
                    indicatorColor = Color(0xFFEFFFF3),
                ),
            )
        }
    }
}