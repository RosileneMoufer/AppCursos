package com.example.appcursos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.appcursos.components.Card

@Composable
fun CourseList() {
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
        Card("Java", "8m ago","description: String")
        Card("Python", "8m ago", "description: String")
        Card("Go", "8m ago", "description: String")
        Card("C#", "8m ago", "description: String")
    }

}