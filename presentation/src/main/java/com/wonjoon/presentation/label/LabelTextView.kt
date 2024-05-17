package com.wonjoon.presentation.label

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowLabelTextView(title : String, labelText : String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp)
    ) {
        Text(text = title, modifier = Modifier.padding(start = 50.dp), fontSize = 16.sp)
        Text(text = ":", modifier = Modifier.padding(start = 10.dp), fontSize = 16.sp)
        Text(text = labelText, modifier = Modifier.padding(start = 10.dp), fontSize = 16.sp)
    }
}