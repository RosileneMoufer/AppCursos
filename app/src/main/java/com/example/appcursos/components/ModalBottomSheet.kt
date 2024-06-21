package com.example.appcursos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcursos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(action:() -> Unit, modifier: Modifier = Modifier){
    ModalBottomSheet(
        onDismissRequest = { action() },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(horizontal = 40.dp)
        ) {
            Text(
                text = "Drawer header",
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 24.sp,
                modifier = modifier.padding(vertical = 10.dp)
            )
            Text(
                text = "Consequat velit qui adipisicing sunt do reprehenderit ad laborum tempor ullamco exercitation.",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 16.sp,
                modifier = modifier.padding(bottom = 10.dp)
            )
            MyButton(text = "Click me")
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Close modal")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomSheet(){
    BottomSheet({})
}