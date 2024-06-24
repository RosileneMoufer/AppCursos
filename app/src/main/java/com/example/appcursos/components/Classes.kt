package com.example.appcursos.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcursos.R
import com.example.appcursos.ui.theme.primary

class ClassItem(
    val title:String,
    val idImage: Int,
    val date:String,
    val description: String,
    var isChecked: MutableState<Boolean> = mutableStateOf(false)
    )

@Composable
fun Classes(classes:List<ClassItem>){
    LazyColumn {
        items(classes){
            item -> ClassesItem(item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClassesItem(item:ClassItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp)
    ) {
        Image(
            painter = painterResource(id = item.idImage),
            contentDescription = item.title,
            modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                item.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 20.sp,
                    color = Color(0xFF000000)
                ),
            )
            CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                Checkbox(
                    checked = item.isChecked.value,
                    onCheckedChange = { if(it) item.isChecked.value = true}
                )
            }
        }
        Text(
            item.description,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 16.sp,
                color = Color(0xFF000000)
            ),
            modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 4.dp)
        )
        Text(
            item.date,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 16.sp,
                color = Color(0xFFBDBDBD)
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewClasses(){
    Classes(listOf(
        ClassItem("Introdução à variáveis", R.drawable.kotlin_logo,"2m ago", "Aprenda a usar variáveis"))
    )
}
