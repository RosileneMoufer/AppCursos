package com.example.appcursos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcursos.screens.login.LoginScreen
import com.example.appcursos.screens.signup.SignUpScreen
import com.example.appcursos.ui.theme.AppCursosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCursosTheme {
                Nav()
            }
        }
    }
}

@Composable
fun Nav(){
    var navController = rememberNavController();
    NavHost(navController = navController, startDestination = "logIn"){
        composable(route = "login"){
            LoginScreen(navController)
        }
        composable(route = "signup"){
            SignUpScreen(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    AppCursosTheme {
        Nav()
    }
}