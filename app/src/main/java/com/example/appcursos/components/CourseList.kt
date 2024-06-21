package com.example.appcursos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

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
        Post("Java", "8m ago","description: String")
        Post("Python", "8m ago", "description: String")
        Post("Go", "8m ago", "description: String")
        Post("C#", "8m ago", "description: String")
    }

}