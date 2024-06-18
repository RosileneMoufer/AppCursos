package com.example.appcursos.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcursos.R

@Composable
fun MyButton( text:String, action:()->Unit = {}, modifier:Modifier = Modifier){
    Button(
        onClick = { action() },
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.inter_semibold)),
            fontSize = 16.sp,
            modifier = Modifier.padding(5.dp)
        )
    }
}