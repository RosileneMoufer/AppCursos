package com.example.appcursos.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appcursos.R
import com.example.appcursos.ui.theme.gray1
import com.example.appcursos.ui.theme.gray2
import com.example.appcursos.ui.theme.primary

enum class UserType{ME, SUPPORT}
class Message(val message:String, val sender:UserType)

@Composable
fun SupportScreen(navController:NavHostController, modifier: Modifier = Modifier){
    var messages = arrayListOf(
        Message("Olá, bom dia. Você está falando com o supporte.", UserType.SUPPORT),
        Message("Olá, estou tendo um problema para acessar o curso X. Pode me ajudar?", UserType.ME),
        Message("Claro! Mas você poderia ser um pouco mais específico?", UserType.SUPPORT),
        Message("Claro! Comprei um curso faz uma semana, mas ele ainda não está aparecendo nos meus cursos.", UserType.ME),
        Message("Vou verificar, só um momento.", UserType.SUPPORT),
        Message("Problema resolvido! Pedimos perdão pelo transtorno", UserType.SUPPORT),
        Message("Gostaria de ajuda com algo mais?", UserType.SUPPORT)
    )
    Scaffold(
        topBar = { TopBarSupport(navController) },
        bottomBar = { ChatTextField(
            messages,
            Modifier.padding(horizontal = 10.dp)) }
    ) {
        LazyColumn(
            modifier
                .padding(it)
                .padding(horizontal = 10.dp)
                .padding(top = 20.dp)
        ) {
            items(items = messages, itemContent = {message ->
                when(message.sender){
                    UserType.ME -> {
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp)
                            ) {
                            Text(
                                text = message.message,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(primary)
                                    .padding(10.dp)
                                    .width(200.dp)
                            )
                        }
                    }
                    UserType.SUPPORT -> {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp)
                        ){
                            Text(
                                text = message.message,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(gray1)
                                    .padding(10.dp)
                                    .width(200.dp)
                            )
                        }
                    }
                }
            })
        }
    }
}

@Composable
private fun ChatTextField(messages: ArrayList<Message>,modifier:Modifier = Modifier){
    var message by remember { mutableStateOf("") }
    OutlinedTextField(
        value = message,
        onValueChange = {message = it},
        label = {Text(text = "Message here...")},
        trailingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(primary)
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.send_icon),
                    contentDescription = "Send",
                    contentScale = ContentScale.Crop,
                )
            }
        },
        shape = RoundedCornerShape(50.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = gray2,
            unfocusedContainerColor = gray1
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
        keyboardActions = KeyboardActions(onSend = {
            message = ""
        }),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBarSupport(navController: NavHostController, modifier:Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Support",
                fontFamily = FontFamily(Font(R.font.inter_semibold)),
                fontSize = 30.sp,
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
            navigationIconContentColor = primary,
            actionIconContentColor = primary
        ),
        navigationIcon = {
            Text(
                text = "Back",
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 16.sp,
                modifier = modifier.padding(start = 10.dp)
            )
        },
        actions = {
            Text(
                text = "Filter",
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 16.sp,
                modifier = modifier.padding(end = 10.dp)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSupportScreen(){
    SupportScreen(navController = rememberNavController())
}