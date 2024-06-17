package com.example.appcursos.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(modifier:Modifier = Modifier){
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Sign Up",
            modifier = Modifier.padding(5.dp)
        )
    }
}