package com.example.appcursos.components.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

class ItemNavigationBar(val nome:String, val icon:ImageVector, val action: ()->Unit)

@Composable
fun BottomAppBarComponent(bottomMenuViewModel : BottomMenuViewModel, navController : NavController) {

    val items = listOf(
        ItemNavigationBar("Cursos", Icons.Filled.Home) { navController.navigate("courses") },
        ItemNavigationBar("Perfil", Icons.Filled.AccountCircle) { navController.navigate("profile") },
        ItemNavigationBar("Suporte", Icons.Filled.Build) { navController.navigate("support") }
    )

    NavigationBar(containerColor = Color.White, contentColor = Color(0xFF5DB075)) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.nome) },
                label = { Text(item.nome) },
                selected = bottomMenuViewModel.itemSelected.value == index,
                onClick = { if (item.nome != "Suporte") {
                    bottomMenuViewModel.itemSelected.value = index
                }; item.action() },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF5DB075),
                    selectedTextColor = Color(0xFF5DB075),
                    indicatorColor = Color(0xFFEFFFF3),
                ),
            )
        }
    }
}