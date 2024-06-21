package com.example.appcursos.components.menu

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

open class BottomMenuViewModel : ViewModel() {
    private val _itemSelected = mutableIntStateOf(0)

    var itemSelected : MutableState<Int> = _itemSelected
}