package com.wonjoon.presentation.country.sheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wonjoon.domain.model.enums.Country
import com.wonjoon.presentation.country.item.CountryItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPickerSheet(
    modifier: Modifier,
    onSelectCountry: (Country) -> Unit,
    onClose: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = onClose,
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        containerColor = Color.White,
        dragHandle = null
    ) {
        Spacer(modifier = Modifier.padding(top = 10.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(Country.entries){
                CountryItem(modifier = modifier.clickable {
                    onSelectCountry(it)
                }, country = it)
            }
        }
    }
}