package com.example.appcursos.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appcursos.R
import com.example.appcursos.components.EmailTextField
import com.example.appcursos.components.MyButton
import com.example.appcursos.components.MyOutlinedButton
import com.example.appcursos.components.PasswordTextField
import com.example.appcursos.ui.theme.AppCursosTheme

@Composable
fun LoginScreen(
    navController:NavHostController,
    modifier: Modifier = Modifier) {
    val loginViewModel = viewModel<LoginViewModel>()
    Scaffold(
        topBar = { TopAppBarLogin() }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(it)
                .imePadding()
                .padding(10.dp)
                .fillMaxHeight()
        ){
            Column {
                EmailTextField(loginViewModel.email,Modifier.padding(bottom = 10.dp))
                PasswordTextField(loginViewModel.password,Modifier.padding(bottom = 40.dp))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                MyOutlinedButton("Log In", modifier = Modifier.padding(bottom = 10.dp))
                MyButton("Sign In", action = {navController.navigate(route = "signup")})
                TextButton(onClick = { navController.navigate(route = "support")}) {
                    Text(
                        text = "Forgot your password?",
                        fontFamily = FontFamily(Font(R.font.inter_semibold)),
                        fontSize = 16.sp,
                    )
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarLogin(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Log In",
                fontFamily = FontFamily(Font(R.font.inter_semibold)),
                fontSize = 30.sp,
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black
        )
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AppCursosTheme {
        LoginScreen(rememberNavController())
    }
}