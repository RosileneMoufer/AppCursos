package com.example.appcursos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun PostList() {
    Column {
        Card("Java", "8m ago","description: String")
        Card("Python", "8m ago", "description: String")
        Card("Go", "8m ago", "description: String")
        Card("C#", "8m ago", "description: String")
    }
}