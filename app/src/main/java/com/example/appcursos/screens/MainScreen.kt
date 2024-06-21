package com.example.appcursos.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcursos.components.menu.BottomAppBarComponent
import com.example.appcursos.components.menu.BottomMenuViewModel
import com.example.appcursos.components.menu.ItemNavigationBar
import com.example.appcursos.screens.classes.ClassesScreen
import com.example.appcursos.screens.profile.ProfileScreen
import com.example.appcursos.screens.support.SupportScreen

@OptIn(ExperimentalMaterial3Api::class)
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
        composable("certificate") { CertificateScreen() }
        composable("support") { SupportScreen(navController) }
    }
}