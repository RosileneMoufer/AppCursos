package com.example.appcursos.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchInput(text: MutableState<String>) {

    OutlinedTextField(
        value = text.value,
        onValueChange = {text.value = it},
        placeholder = { Text(text = "Search") },
        shape = RoundedCornerShape(50),
        colors = OutlinedTextFieldDefaults.colors(
            //containerColor = Color(0xFFF6F6F6), // does not work
            unfocusedBorderColor = Color(0xFFE8E8E8),
            focusedBorderColor = Color(0xFFE8E8E8),
            //textColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 12.dp),
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            color = Color(0xFFBDBDBD)
        )
    )
}