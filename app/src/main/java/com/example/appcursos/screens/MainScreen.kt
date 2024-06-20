package com.example.appcursos.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcursos.components.BottomAppBarComponent
import com.example.appcursos.screens.support.Support

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomAppBarComponent(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavBottomBarController(navController = navController)
            }
        },
    )
}

@Composable
fun NavBottomBarController(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "courses") {
        composable("courses") { CoursesScreen() }
        composable("classes") { ClassesScreen() }
        composable("profile") { ProfileScreen() }
        composable("certificate") { CertificateScreen() }
        composable("support") { Support() }
    }
}