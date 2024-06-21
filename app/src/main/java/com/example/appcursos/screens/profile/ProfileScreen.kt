package com.example.appcursos.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcursos.components.BottomSheet
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appcursos.components.ImageProfile
import com.example.appcursos.components.PhotoList
import com.example.appcursos.components.SetSystemBarsColors
import com.example.appcursos.components.SwitchButton
import com.example.appcursos.components.SwitchTextButton
import com.example.appcursos.components.menu.TopMenu

@Composable
fun ProfileScreen(navController: NavController, logOutAction: ()->Unit) {
    SetSystemBarsColors(
        setStatusBarColor = Color(0xFF5DB075),
        setNavigationBarColor = Color(0xFFFFFFFF)
    )

    Body(logOutAction)
}

@Composable
fun Body( logOutAction: ()->Unit) {
    var viewModel = viewModel<ProfileViewModel>()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF5DB075))
                .padding(16.dp, 0.dp)
                .zIndex(1F),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TopMenu(
                title = "Profile",
                titleButtonLeft = "Settings",
                titleButtonRight = "Logout",
                actionButtonRight = logOutAction,
                actionButtonColor = Color(0xFFFFFFFF),
                titleColor = Color(0xFFFFFFFF),
                backgroundColor = Color(0xFF5DB075)
            )
            ImageProfile()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFFFFF))
                .padding(start = 16.dp, end = 16.dp, top = 48.dp, bottom = 16.dp),
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

            SwitchButton(
                {viewModel.isPostsActive.value = true},
                {viewModel.isPostsActive.value = false},
                viewModel.isPostsActive.value)

            Spacer(modifier = Modifier.height(16.dp))

            if (viewModel.isPostsActive.value) {
                //PostList(navController)
                PhotoList()
            } else {
                PhotoList()
            }
        }
        if(viewModel.isModalOpen.value)
            BottomSheet({viewModel.isModalOpen.value = false})
    }
}