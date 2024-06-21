package com.example.appcursos.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appcursos.screens.classes.ClassesViewModel

@Composable
fun CheckBoxClasses(viewModel: ClassesViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.Right
    ) {
        Checkbox(
            checked = viewModel.completedClasses.value[1],
            onCheckedChange = { viewModel.completedClasses.value[1] = it }
        )
        Checkbox(
            checked = viewModel.completedClasses.value[1],
            onCheckedChange = { viewModel.completedClasses.value[1] = it }
        )
        Checkbox(
            checked = viewModel.completedClasses.value[2],
            onCheckedChange = {
                viewModel.completedClasses.value[2] = it

                if (!viewModel.completedClasses.value.contains(false)) {
                    viewModel.completedCourse.value = true
                }
            }
        )
    }
}