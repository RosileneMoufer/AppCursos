package com.example.appcursos.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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

class ProfileActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCursosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF5DB075)
                ) {
                    Body()
                }
            }
        }
    }
}

@Composable
fun Body() {
    var isPostsActive = true

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TopMenu(
            title = "Profile",
            titleButtonLeft = "Settings",
            titleButtonRight = "Logout",
            actionButtonColor = Color(0xFFFFFFFF),
            titleColor = Color(0xFFFFFFFF))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2F)
                .background(Color(0xFF5DB075))
        ) {
            // foto
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFFFFF))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
                        border = BorderStroke(1.dp,Color(0xFFBDBDBD)),
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
                        containerColor = Color(0xFFFFFFFF)
                    )
                ) {
                    Text(
                        text = "Posts",
                        style = TextStyle(
                            color = Color(0xFF5DB075),
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
                        containerColor = Color(0xFFF6F6F6)
                    )
                ) {
                    Text(
                        text = "Photos",
                        style = TextStyle(
                            color = Color(0xFFBDBDBD),
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

