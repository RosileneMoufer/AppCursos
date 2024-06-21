package com.example.appcursos.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SwitchButton(
    onClickButtonLeft : () -> Unit,
    onClickButtonRight : () -> Unit,
    isButtonActivity: Boolean,
) {
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
            onClick = onClickButtonLeft,
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .fillMaxWidth()
                .weight(1F),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isButtonActivity) Color(0xFFFFFFFF) else Color(0xFFF6F6F6)
            )
        ) {
            SwitchTextButton(text = "Posts", isButtonActivity = isButtonActivity)
        }

        Button(
            onClick = onClickButtonRight,
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .fillMaxWidth()
                .weight(1F),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (!isButtonActivity) Color(0xFFFFFFFF) else Color(0xFFF6F6F6)
            )
        ) {
            SwitchTextButton(text = "Photos", isButtonActivity = !isButtonActivity)
        }
    }
}


@Composable
fun SwitchTextButton(text: String, isButtonActivity: Boolean) {
    Text(
        text = text,
        style = TextStyle(
            color = if (isButtonActivity) Color(0xFF5DB075) else Color(0xFFBDBDBD),
            fontWeight = FontWeight.W600,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier.padding(4.dp)
    )
}

