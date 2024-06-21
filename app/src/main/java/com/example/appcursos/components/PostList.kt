package com.example.appcursos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun PostList(navController: NavController) {
    /*
    if (list.isEmpty()) {
        Text(text = "Ainda não há nada")
    } else {
        list.let {
            LazyColumn {
                items(it) {
                    Card("Java", "8m ago","description: String")
                }
            }
        }
    }
*/

    Column {
        Post("Java", "8m ago","description: String", navController)
        Post("Python", "8m ago", "description: String", navController)
        Post("Go", "8m ago", "description: String", navController)
        Post("C#", "8m ago", "description: String", navController)
    }

}