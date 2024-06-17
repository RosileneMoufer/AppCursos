package com.example.appcursos.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcursos.R
import com.example.appcursos.components.EmailTextField
import com.example.appcursos.components.MyButton
import com.example.appcursos.components.MyOutlinedButton
import com.example.appcursos.components.PasswordTextField
import com.example.appcursos.ui.theme.AppCursosTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {TopAppBarLogin()}
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(it)
                .padding(10.dp)
        ){
            EmailTextField(Modifier.padding(bottom = 10.dp))
            PasswordTextField(Modifier.padding(bottom = 40.dp))
            MyOutlinedButton(Modifier.padding(bottom = 10.dp))
            MyButton()
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = "Forgot your password?",
                    fontFamily = FontFamily(Font(R.font.inter_semibold)),
                    fontSize = 16.sp,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarLogin(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(title = {
        Text(
            text = "Log In",
            fontFamily = FontFamily(Font(R.font.inter_semibold)),
            fontSize = 30.sp
        )
    })
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AppCursosTheme {
        LoginScreen()
    }
}