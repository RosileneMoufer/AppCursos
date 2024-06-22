package com.example.appcursos.screens.courses

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CoursesViewModel:ViewModel() {
    var textFromTextField = mutableStateOf("")
    var isModalOpen = mutableStateOf(false)
}