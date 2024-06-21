package com.example.appcursos.screens.profile

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

open class ProfileViewModel: ViewModel() {
    private val _isPostActive = mutableStateOf(true)

    var isPostActive:MutableState<Boolean> = _isPostActive
}