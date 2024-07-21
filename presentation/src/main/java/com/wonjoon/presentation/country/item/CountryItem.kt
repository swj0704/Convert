package com.wonjoon.presentation.country.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.wonjoon.domain.model.enums.Country
import com.wonjoon.presentation.ui.theme.ConvertTheme

@Composable
fun CountryItem(
    modifier: Modifier,
    country: Country,
) {
    Row(modifier = modifier.background(Color.White).padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        if (country.imageUrl.isNotEmpty()) {
            Image(
                painter = rememberImagePainter(country.imageUrl),
                contentDescription = country.countryName,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
            )
        }

        Text(modifier = Modifier.weight(1f).padding(start = 10.dp), text = country.currency.currency)
    }
}


@Preview(showBackground = true)
@Composable
fun CountryItemPreview() {
    ConvertTheme {
        CountryItem(modifier = Modifier.fillMaxWidth(), country = Country.KR)
    }
}