package com.example.appcursos.screens.classes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.appcursos.components.ClassItem

open class ClassesViewModel : ViewModel() {
    var classes = mutableListOf(
        ClassItem("Introdução à variáveis", "2m ago", "Aprenda a usar variáveis"),
        ClassItem("Funções", "2m ago", "Aprenda a usar métodos e funções"),
        ClassItem("Laços de repetição", "2m ago", "Aprenda a usar for, while, do while.")
    )
    var textFromTextField = mutableStateOf("")
}