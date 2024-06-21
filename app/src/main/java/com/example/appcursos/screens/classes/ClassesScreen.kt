package com.example.appcursos.screens.classes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appcursos.components.CheckBoxClasses
import com.example.appcursos.components.ClassItem
import com.example.appcursos.components.Classes
import com.example.appcursos.components.PhotoList
import com.example.appcursos.components.SearchInput
import com.example.appcursos.components.menu.BottomAppBarComponent
import com.example.appcursos.components.menu.BottomMenuViewModel
import com.example.appcursos.components.menu.TopMenu

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClassesScreen(bottomMenuViewModel : BottomMenuViewModel, navController: NavController) {
    val classesViewModel = viewModel<ClassesViewModel>()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomAppBarComponent(bottomMenuViewModel, navController = navController) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 0.dp)
        ) {
            TopMenu(
                title = "Aulas",
                titleButtonLeft = "Voltar",
                actionButtonLeft = { navController.navigate("courses") },
                titleButtonRight = "Filtro",
                actionButtonColor = Color(0xFF5DB075),
                titleColor = Color(0XFF000000),
                backgroundColor = Color(0xFFFFFFFF),
            )
            SearchInput()
            Classes(classes = listOf(
                ClassItem("Introdução à variáveis", "2m ago", "Aprenda a usar variáveis"),
                ClassItem("Funções", "2m ago", "Aprenda a usar métodos e funções"),
                ClassItem("Laços de repetição", "2m ago", "Aprenda a usar for, while, do while."),
            ))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewClasses(){
    ClassesScreen(navController = rememberNavController())
}
