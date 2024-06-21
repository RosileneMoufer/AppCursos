package com.example.appcursos.screens.classes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

open class ClassesViewModel : ViewModel() {
    private val _completedCourse = mutableStateOf(false)
    private val _completedClasses = mutableStateOf(arrayOf(false, false, false))

    var completedCourse : MutableState<Boolean> = _completedCourse
    var completedClasses : MutableState<Array<Boolean>> = _completedClasses
}