package com.example.appcursos.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.appcursos.ui.theme.AppCursosTheme
import com.example.appcursos.components.Card
import com.example.appcursos.components.PhotoList
import com.example.appcursos.components.Post
import com.example.appcursos.components.PostList
import com.example.appcursos.components.SearchInput
import com.example.appcursos.components.TopMenu

class CursosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCursosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp, 0.dp)
                    ) {
                        TopMenu(
                            title = "Cursos",
                            titleButtonLeft = "Logout",
                            titleButtonRight = "Filtro",
                            actionButtonColor = Color(0xFF5DB075),
                            titleColor = Color(0XFF000000),
                            backgroundColor = Color(0xFF5DB075)
                        )
                        SearchInput()
                        Column(
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        ) {
                            PostList()
                            PhotoList()
                        }
                    }
                }
            }
        }
    }
}

