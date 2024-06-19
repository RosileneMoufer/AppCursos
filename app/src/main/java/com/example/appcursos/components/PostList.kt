package com.example.appcursos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PostList() {
    Column {
        Card("Java", "8m ago","description: String")
        Card("Python", "8m ago", "description: String")
        Card("Go", "8m ago", "description: String")
        Card("C#", "8m ago", "description: String")
    }
}