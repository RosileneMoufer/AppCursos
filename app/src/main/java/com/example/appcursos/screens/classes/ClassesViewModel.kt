package com.example.appcursos.screens.classes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.appcursos.R
import com.example.appcursos.components.ClassItem

open class ClassesViewModel : ViewModel() {
    var classes = mutableListOf(
        ClassItem("Introdução à variáveis", R.drawable.kotlin_logo,"2m ago", "Aprenda a usar variáveis"),
        ClassItem("Funções", R.drawable.kotlin_logo,"2m ago", "Aprenda a usar métodos e funções"),
        ClassItem("Laços de repetição", R.drawable.kotlin_logo,"2m ago", "Aprenda a usar for, while, do while.")
    )
    var textFromTextField = mutableStateOf("")
}