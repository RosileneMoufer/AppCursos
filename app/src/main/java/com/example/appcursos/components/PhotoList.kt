package com.example.appcursos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.appcursos.components.Post

@Composable
fun PhotoList() {
    Column {
        Photo("Java", "8m ago","description: String")
        Photo("Python", "8m ago", "description: String")
        Photo("Go", "8m ago", "description: String")
        Photo("C#", "8m ago", "description: String")
    }
}