package com.example.appcursos.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcursos.components.menu.BottomAppBarComponent
import com.example.appcursos.screens.support.SupportScreen

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
        composable("courses") { CoursesScreen(navController) }
        composable("classes") { ClassesScreen() }
        composable("profile") { ProfileScreen() }
        composable("certificate") { CertificateScreen() }
        composable("support") { SupportScreen(navController) }
    }
}