package com.example.appcursos.screens.classes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appcursos.components.ClassItem
import com.example.appcursos.components.Classes
import com.example.appcursos.components.PhotoList
import com.example.appcursos.components.SearchInput
import com.example.appcursos.components.SwitchButton
import com.example.appcursos.components.menu.BottomAppBarComponent
import com.example.appcursos.components.menu.BottomMenuViewModel
import com.example.appcursos.components.menu.TopMenu
import com.example.appcursos.ui.theme.primary

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClassesScreen(bottomMenuViewModel : BottomMenuViewModel, navController: NavController) {
    val classesViewModel = viewModel<ClassesViewModel>()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = { BottomAppBarComponent(bottomMenuViewModel, navController = navController) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
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
                title = "Aulas",
                titleButtonLeft = "Voltar",
                actionButtonLeft = { navController.navigate("courses") },
                titleButtonRight = "Filtro",
                actionButtonColor = Color(0xFF5DB075),
                titleColor = Color(0XFF000000),
                backgroundColor = Color(0xFFFFFFFF),
            )
            SearchInput(classesViewModel.textFromTextField)
            Box(){
                Classes(classes = classesViewModel.classes)
                if(isCourseFinished(classesViewModel.classes)){
                    ExtendedFloatingActionButton(
                        onClick = { navController.navigate("certificate")},
                        containerColor = primary,
                        contentColor = Color.White,
                        modifier = Modifier
                            .padding(end = 10.dp, bottom = 95.dp)
                            .align(Alignment.BottomEnd)
                    ) {
                        Text(text = "Abrir certificado")
                    }
                }
            }

        }
    }
}

private fun isCourseFinished(classes: List<ClassItem>):Boolean{
    val concludedClasses = classes.filter { it.isChecked.value }
    return concludedClasses.size == classes.size
}

@Preview(showBackground = true)
@Composable
fun PreviewClasses(){
    var bottomMenuViewModel = viewModel<BottomMenuViewModel>()
    ClassesScreen(bottomMenuViewModel,navController = rememberNavController())
}
