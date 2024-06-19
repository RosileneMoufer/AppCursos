package com.example.appcursos.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcursos.R
import com.example.appcursos.ui.theme.gray1
import com.example.appcursos.ui.theme.gray2
import com.example.appcursos.ui.theme.primary
import com.example.appcursos.ui.theme.secondary

@Composable
fun PasswordTextField(modifier: Modifier = Modifier){
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = {password = it},
        label = {
            Text(
                text = "Password",
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 16.sp
            )
        },
        visualTransformation = if(showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            Text(
                text = if(showPassword)  "Hide" else "Show",
                color = primary,
                fontFamily = FontFamily(Font(R.font.inter_semibold)),
                fontSize = 16.sp,
                modifier =
                    Modifier
                        .padding(end = 15.dp)
                        .clickable { showPassword = !showPassword }
            ) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = secondary,
            unfocusedBorderColor = gray1,
            unfocusedTextColor = gray2,
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
    )
}