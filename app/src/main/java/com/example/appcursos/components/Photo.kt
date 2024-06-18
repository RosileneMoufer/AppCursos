package com.example.appcursos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Post(title: String, date: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF6F6F6)))
        Text(
            title,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                lineHeight = 20.sp,
                color = Color(0xFF000000)
            ),
            modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp)
        )
        Text(
            description,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 16.sp,
                color = Color(0xFF000000)
            ),
            modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 4.dp)
        )
        Text(
            date,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 16.sp,
                color = Color(0xFFBDBDBD)
            ),
        )
    }
}