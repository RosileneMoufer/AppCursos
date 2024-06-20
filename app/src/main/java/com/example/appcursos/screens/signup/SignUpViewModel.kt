package com.example.appcursos.screens.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.appcursos.screens.login.LoginViewModel

class SignUpViewModel: LoginViewModel() {
    private val _name = mutableStateOf("")
    private val _isChecked = mutableStateOf(false)

    var name: MutableState<String> = _name
    var isChecked: MutableState<Boolean> = _isChecked
}