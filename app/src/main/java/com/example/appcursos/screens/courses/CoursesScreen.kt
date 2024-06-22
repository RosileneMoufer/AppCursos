package com.example.appcursos.screens.courses

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appcursos.components.LoggoutBottomSheet
import com.example.appcursos.components.PhotoList
import com.example.appcursos.components.PostList
import com.example.appcursos.components.SearchInput
import com.example.appcursos.components.menu.BottomAppBarComponent
import com.example.appcursos.components.menu.BottomMenuViewModel
import com.example.appcursos.components.menu.TopMenu

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CoursesScreen(bottomMenuViewModel: BottomMenuViewModel, navController: NavController, logOutAction: ()->Unit) {

    val viewModel = viewModel<CoursesViewModel>()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomAppBarComponent(bottomMenuViewModel, navController = navController) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    end = 16.dp,
                    start = 16.dp,
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding()
                )
        ) {
            TopMenu(
                title = "Cursos",
                titleButtonLeft = "Logout",
                actionButtonLeft = {viewModel.isModalOpen.value = true},
                titleButtonRight = "Filtro",
                actionButtonColor = Color(0xFF5DB075),
                titleColor = Color(0XFF000000),
                backgroundColor = Color(0xFFFFFFFF)
            )
            SearchInput(viewModel.textFromTextField)
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                PostList(navController)
                PhotoList()
            }
            if(viewModel.isModalOpen.value)
                LoggoutBottomSheet(logOutAction, {viewModel.isModalOpen.value = false})
        }
    }

}

