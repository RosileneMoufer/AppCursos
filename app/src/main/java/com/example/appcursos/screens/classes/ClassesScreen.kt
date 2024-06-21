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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appcursos.components.CheckBoxClasses
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
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // elemento aula... carrossel?d

                    if (classesViewModel.completedCourse.value) Button(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFF5DB075)
                        ),
                        onClick = {
                        navController.navigate("certificate")
                    }) {
                        Text("Certificado")
                    } else CheckBoxClasses(viewModel = classesViewModel)
                }

                PhotoList()
            }
        }
    }
}
