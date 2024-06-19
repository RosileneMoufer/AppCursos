package com.example.appcursos.screens.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _email = mutableStateOf("")
    private val _password = mutableStateOf("")

    var email:MutableState<String> = _email

    var password: MutableState<String> = _password
}