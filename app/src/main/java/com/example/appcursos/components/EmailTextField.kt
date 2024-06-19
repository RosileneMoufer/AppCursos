package com.example.appcursos.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.appcursos.R
import com.example.appcursos.ui.theme.gray1
import com.example.appcursos.ui.theme.gray2
import com.example.appcursos.ui.theme.secondary

@Composable
fun EmailTextField(email: MutableState<String>,modifier: Modifier = Modifier){
    OutlinedTextField(
        value = email.value,
        onValueChange = {email.value = it},
        label = {
            Text(
                text = "Email",
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 16.sp
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = secondary,
            unfocusedBorderColor = gray1,
            unfocusedTextColor = gray2
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
    )
}