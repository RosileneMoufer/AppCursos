package com.example.appcursos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PostList() {
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