package com.wonjoon.presentation.header

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wonjoon.domain.model.enums.Country
import com.wonjoon.presentation.R

@Composable
fun HeaderView(sendCountry: Country, receiveCountry: Country){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 30.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = sendCountry.currency.name, modifier = Modifier.padding(start = 50.dp, end = 10.dp), fontSize = 30.sp)
        Icon(painter = painterResource(id = R.drawable.ic_right_arrow), contentDescription = "화살표", modifier = Modifier.width(30.dp).height(40.dp))
        Text(text = receiveCountry.currency.name, modifier = Modifier.padding(start = 10.dp), fontSize = 30.sp)
        Text(text = "환전", modifier = Modifier.padding(start = 10.dp), fontSize = 30.sp)
    }
}