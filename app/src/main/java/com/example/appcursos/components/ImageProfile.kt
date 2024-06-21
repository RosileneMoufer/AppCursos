package com.example.appcursos.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.appcursos.R

@Composable
fun ImageProfile() {
    val offset = with(LocalDensity.current) {
        (160.dp * 0.08F ).toPx()
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .offset(y = 40.dp)
            .clip(RoundedCornerShape(100))
            .background(Color(0xFFFFFFFF))
            .width(160.dp)
            .height(160.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_profile),
            contentDescription = "",
            alignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(percent = 100))
                .height(150.dp)
                .width(150.dp)
                .align(Alignment.Center)
        )
    }
}

