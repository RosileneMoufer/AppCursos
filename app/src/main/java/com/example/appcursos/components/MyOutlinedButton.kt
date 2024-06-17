package com.example.appcursos.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appcursos.ui.theme.primary

@Composable
fun MyOutlinedButton(modifier: Modifier = Modifier){
    OutlinedButton(
        onClick = { /*TODO*/ },
        border = BorderStroke(1.dp, color = primary),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Log In",
            modifier = Modifier.padding(5.dp)
        )
    }
}