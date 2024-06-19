package com.example.appcursos.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcursos.components.PhotoList
import com.example.appcursos.components.PostList
import com.example.appcursos.components.TopMenu
import com.example.appcursos.ui.theme.AppCursosTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.util.Stack

class ProfileActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppCursosTheme {
                SetStatusBarColor(
                    setStatusBarColor = Color(0xFF5DB075),
                    setNavigationBarColor = Color(0xFFFFFFFF)
                )

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFFFFF)
                ) {
                    Body()
                }
            }
        }
    }
}

@Composable
fun SetStatusBarColor(setStatusBarColor: Color, setNavigationBarColor: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        //systemUiController.setSystemBarsColor(color)
        systemUiController.setStatusBarColor(setStatusBarColor)
        systemUiController.setNavigationBarColor(setNavigationBarColor)
    }
}

@Composable
fun Body() {
    var isPostsActive by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFF5DB075))
                .padding(16.dp, 0.dp)
        ) {
            TopMenu(
                title = "Profile",
                titleButtonLeft = "Settings",
                titleButtonRight = "Logout",
                actionButtonColor = Color(0xFFFFFFFF),
                titleColor = Color(0xFFFFFFFF),
                backgroundColor = Color(0xFF5DB075))
            Box(
                modifier = Modifier
                    .background(Color(0xFF5DB075))
                    .aspectRatio(2.2F),
                contentAlignment = Alignment.Center
            ) {
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color.Gray)
                    .border(
                        border = BorderStroke(8.dp, Color.White),
                        shape = RoundedCornerShape(50)
                    )
                    .width(160.dp)
                    .height(160.dp)
                    //.align(Alignment.BottomCenter)
                ){
                    // image
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFFFFF))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "User name",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 36.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF000000)
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "A mantra goes here",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF000000)
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(50))
                    .border(
                        border = BorderStroke(1.dp, Color(0xFFBDBDBD)),
                        shape = RoundedCornerShape(50)
                    )
                    .background(Color(0xFFF6F6F6))
            ) {
                Button(
                    onClick = { isPostsActive = true },
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .fillMaxWidth()
                        .weight(1F),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isPostsActive) Color(0xFFFFFFFF) else Color(0xFFF6F6F6)
                    )
                ) {
                    Text(
                        text = "Posts",
                        style = TextStyle(
                            color = if (isPostsActive) Color(0xFF5DB075) else Color(0xFFBDBDBD),
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(4.dp)
                    )
                }
                Button(
                    onClick = { isPostsActive = false },
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .fillMaxWidth()
                        .weight(1F),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isPostsActive) Color(0xFFF6F6F6) else Color(0xFFFFFFFF)
                    )
                ) {
                    Text(
                        text = "Photos",
                        style = TextStyle(
                            color = if (isPostsActive) Color(0xFFBDBDBD) else Color(0xFF5DB075),
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            if (isPostsActive) {
                PostList()
            } else {
                PhotoList()
            }
        }
    }
}

@Preview
@Composable
fun Teste() {
    Body()
}

