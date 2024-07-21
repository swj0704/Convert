package com.wonjoon.presentation.label

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.wonjoon.domain.model.enums.Country
import com.wonjoon.presentation.R
import com.wonjoon.presentation.ui.theme.ConvertTheme

@OptIn(ExperimentalCoilApi::class)
@Composable
fun AmountLabelTextView(visibleLeftIcon : Boolean, value : String, country: Country, onValueChange: (String) -> Unit, onClickCountry: () -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, start = 30.dp, end = 30.dp)
    ) {
        if(visibleLeftIcon){
            Icon(painter = painterResource(id = R.drawable.ic_equal_icon), contentDescription = "등호", modifier = Modifier
                .width(30.dp)
                .height(30.dp))
        }
        Column(
            modifier = Modifier
                .weight(1f) // 상위 컴포넌트와의 비율을 설정
                .height(30.dp)
                .padding(horizontal = 10.dp), // 최대 높이를 차지하도록 설정
            verticalArrangement = Arrangement.Center, // 내용을 수직 중앙 정렬
            horizontalAlignment = Alignment.CenterHorizontally // 내용을 수평 중앙 정렬
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)// 상위 컴포넌트와의 비율을 설정
                    .height(30.dp)// 최대 높이를 차지하도록 설정
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = { newText -> onValueChange(newText.filter { it.isDigit() || it == ',' || it == '.' }) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .height(29.dp)
                        .fillMaxWidth()
                        .focusable(visibleLeftIcon.not()),
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        textAlign = TextAlign.Left
                    ),
                )
                Text(text = country.currency.symbol)
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Black))
        }

        if (country.imageUrl.isNotEmpty()) {
            Image(
                painter = rememberImagePainter(country.imageUrl),
                contentDescription = country.countryName,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clickable {
                        onClickCountry()
                    }
            )
        }
    }
}

