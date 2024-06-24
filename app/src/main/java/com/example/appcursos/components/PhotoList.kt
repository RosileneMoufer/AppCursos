package com.example.appcursos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.appcursos.R

@Composable
fun PhotoList() {
    val listOfPhoto = listOf(
        ItemPostList("Java", R.drawable.java_logo, "8m ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
        ItemPostList("Python", R.drawable.python_logo, "8m ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
        ItemPostList("Kotlin", R.drawable.kotlin_logo, "8m ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
        ItemPostList("C#", R.drawable.csharp_logo, "8m ago", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
    )

    Column {
        for (it in listOfPhoto) {
            Photo(it.title, it.idImage, it.date, it.description)
        }
    }
}

