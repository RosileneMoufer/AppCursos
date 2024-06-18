package com.example.appcursos.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcursos.R
import com.example.appcursos.components.DefaultCheckbox
import com.example.appcursos.components.DefaultTextField
import com.example.appcursos.components.EmailTextField
import com.example.appcursos.components.MyButton
import com.example.appcursos.components.MyOutlinedButton
import com.example.appcursos.components.PasswordTextField
import com.example.appcursos.ui.theme.AppCursosTheme
import com.example.appcursos.ui.theme.gray3
import com.example.appcursos.ui.theme.primary

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = { TopAppBarSignIn() }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(it)
                .imePadding()
                .padding(10.dp)
                .fillMaxHeight()
        ){
            Column {
                DefaultTextField("Nome", Modifier.padding(bottom = 10.dp))
                EmailTextField(Modifier.padding(bottom = 10.dp))
                PasswordTextField(Modifier.padding(bottom = 10.dp))
                DefaultCheckbox(
                    text = "I would like to receive your newsletter and other promotional information."
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                MyButton("Sign Up")
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Forgot your password?",
                        fontFamily = FontFamily(Font(R.font.inter_semibold)),
                        fontSize = 16.sp,
                    )
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSignIn(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Sign In",
                fontFamily = FontFamily(Font(R.font.inter_semibold)),
                fontSize = 30.sp,
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
            navigationIconContentColor = gray3,
            actionIconContentColor = primary
        ),
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.close_icon),
                contentDescription = "Close Icon",
                modifier = Modifier.padding(start = 10.dp)
            )
        },
        actions = {
            Text(
                text = "Login",
                modifier = modifier.padding(end = 10.dp)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    AppCursosTheme {
        SignInScreen()
    }
}