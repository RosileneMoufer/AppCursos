package com.example.appcursos.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CertificateScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,

        ) {
        Box(
            modifier = Modifier
                .background(Color(0xFF5DB075))
                .padding(25.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFFFFFFF))
                    .padding(24.dp, 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Parabéns!",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.W600,
                        lineHeight = 30.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF000000)
                    )
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = "Consequat velit qui adipisicing sunt do reprehenderit ad " +
                            "laborum tempor ullamco exercitation. Ullamco tempor " +
                            "adipisicing et voluptate duis sit esse aliqua esse ex " +
                            "dolore esse. Consequat velit qui adipisicing sunt",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF666666)
                    )
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5DB075)
                    )
                ) {
                    Text(
                        text = "Certificado",
                        style = TextStyle(
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(4.dp)
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFFFFF)
                    )
                ) {
                    Text(
                        text = "Voltar",
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
            }
        }
    }
}
