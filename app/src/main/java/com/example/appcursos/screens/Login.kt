package com.example.appcursos.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcursos.components.EmailTextField
import com.example.appcursos.components.PasswordTextField
import com.example.appcursos.ui.theme.AppCursosTheme
import com.example.appcursos.ui.theme.gray1
import com.example.appcursos.ui.theme.gray2
import com.example.appcursos.ui.theme.primary
import com.example.appcursos.ui.theme.secondary

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
            EmailTextField()
            PasswordTextField()
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Sign Up")
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Log In")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Forgot your password?")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarLogin(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(title = {
        Text(text = "Log In")
    })
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AppCursosTheme {
        LoginScreen()
    }
}