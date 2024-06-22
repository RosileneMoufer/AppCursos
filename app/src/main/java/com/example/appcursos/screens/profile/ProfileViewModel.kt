package com.example.appcursos.screens.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProfileViewModel:ViewModel() {
    private val _isPostsActive = mutableStateOf(true)
    private val _isModalOpen = mutableStateOf(false)

    var isPostsActive = _isPostsActive
    var isModalOpen = _isModalOpen
}