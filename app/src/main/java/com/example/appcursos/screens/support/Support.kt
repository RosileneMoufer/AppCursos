package com.example.appcursos.screens.support

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appcursos.R
import com.example.appcursos.components.menu.TopMenu
import com.example.appcursos.ui.theme.gray1
import com.example.appcursos.ui.theme.gray2
import com.example.appcursos.ui.theme.primary

enum class UserType{ME, SUPPORT}
class Message(val message:String, val sender: UserType)

@Composable
fun SupportScreen(navController:NavHostController, modifier: Modifier = Modifier){
    val supportViewModel = viewModel<SupportViewModel>()
    Scaffold(
        //topBar = { TopBarSupport(navController) },
        Modifier
            .background(Color.White)
            .imePadding(),
        bottomBar = {
            ChatTextField(
                {supportViewModel.addMessage(it)},
                Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
            ) },
    ) {
        Column(
            Modifier.padding(
                end = 16.dp,
                start = 16.dp,
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding()
            )
        ) {
            TopMenu(
                title = "Suporte",
                titleButtonLeft = "Back",
                actionButtonLeft = { navController.popBackStack() },
                titleButtonRight = "Filter",
                actionButtonColor = primary,
                titleColor = Color.Black,
                backgroundColor = Color.White
            )
            Body(messages = supportViewModel.messages)
        }
    }
}

@Composable
private fun Body(messages:SnapshotStateList<Message>, modifier: Modifier = Modifier){
    LazyColumn(
        reverseLayout = true,
        state = rememberLazyListState(),
        modifier = modifier
            .padding(top = 8.dp)
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

@Composable
private fun ChatTextField(action: (String)->Unit, modifier: Modifier = Modifier){
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
                    .padding(10.dp)
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(primary)
                    .clickable {
                        action(message)
                        message = ""
                    }
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
            action(message)
            message = ""
        }),
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    )
}

/*
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

 */

@Preview(showBackground = true)
@Composable
fun PreviewSupportScreen(){
    SupportScreen(navController = rememberNavController())
}