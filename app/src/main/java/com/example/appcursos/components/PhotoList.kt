package com.example.appcursos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.appcursos.components.Post

@Composable
fun PhotoList() {
    Column {
        Post("Java", "8m ago","description: String")
        Post("Python", "8m ago", "description: String")
        Post("Go", "8m ago", "description: String")
        Post("C#", "8m ago", "description: String")
    }
}