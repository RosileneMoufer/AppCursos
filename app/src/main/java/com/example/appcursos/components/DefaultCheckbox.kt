package com.example.appcursos.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcursos.R
import com.example.appcursos.ui.theme.gray2
import com.example.appcursos.ui.theme.gray4

@Composable
fun DefaultCheckbox(text: String, modifier: Modifier = Modifier){
    var isCheckboxChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.Top,
        modifier = modifier
    ){
        Checkbox(
            checked = isCheckboxChecked,
            onCheckedChange = {isCheckboxChecked = it},
            colors = CheckboxDefaults.colors(
                uncheckedColor = gray2
            ),
            modifier = Modifier.padding(top = 0.dp)
        )
        Text(
            text = text,
            color = gray4,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontSize = 14.sp
        )
    }
}