package com.example.appcursos.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcursos.components.menu.BottomMenuViewModel
import com.example.appcursos.screens.classes.ClassesScreen
import com.example.appcursos.screens.courses.CoursesScreen
import com.example.appcursos.screens.profile.ProfileScreen
import com.example.appcursos.screens.support.SupportScreen

@Composable
fun MainScreen(logOutAction: ()->Unit) {
    val navController = rememberNavController()
    val bottomMenuViewModel = viewModel<BottomMenuViewModel>()

    NavBottomBarController(bottomMenuViewModel, navController, logOutAction)
}

@Composable
fun NavBottomBarController(bottomMenuViewModel : BottomMenuViewModel, navController: NavHostController, logOutAction: ()->Unit) {

    NavHost(navController = navController, startDestination = "courses") {
        composable("courses") { CoursesScreen(bottomMenuViewModel, navController, logOutAction) }
        composable("classes") { ClassesScreen(bottomMenuViewModel, navController) }
        composable("profile") { ProfileScreen(bottomMenuViewModel, navController, logOutAction) }
        composable("certificate") { CertificateScreen(navController) }
        composable("support") { SupportScreen(navController) }
    }
}