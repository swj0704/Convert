package com.wonjoon.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wonjoon.domain.model.enums.Country
import com.wonjoon.presentation.country.sheet.CountryPickerSheet
import com.wonjoon.presentation.format.formatNumber
import com.wonjoon.presentation.format.getNumber
import com.wonjoon.presentation.header.HeaderView
import com.wonjoon.presentation.label.AmountLabelTextView
import com.wonjoon.presentation.label.RowLabelTextView

@Composable
fun MainView(viewModel: MainViewModel = hiltViewModel()) {
    val rate : Double by viewModel.rate.observeAsState(0.0)
    val amount : Double by viewModel.amount.observeAsState(0.0)
    val date : String by viewModel.date.observeAsState("")
    val send : Country by viewModel.send.observeAsState(Country.KR)
    val receive : Country by viewModel.receive.observeAsState(Country.US)
    val sendAmount = rememberSaveable {
        mutableStateOf("0")
    }
    var isCountryPickerSheetOpen by remember{
        mutableStateOf(false)
    }

    var isPickerModeSendCountry by remember{
        mutableStateOf(false)
    }

    LaunchedEffect(send, receive) {
        viewModel.convert(send.currency.name, receive.currency.name, receive.currency.base.toString(), true)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderView(send, receive)
        RowLabelTextView("내 적용 환율", "${receive.currency.base}${receive.currency.currency} 당 ${rate}${send.currency.currency}")//1 달러 당 1355 원
        RowLabelTextView("환율 조회 시간", date)
        AmountLabelTextView(visibleLeftIcon = false, value = sendAmount.value, country = send, {
            val number = getNumber(it)
            sendAmount.value = formatNumber(number)
            viewModel.convert(receive.currency.name, send.currency.name, number.toString(), false)
        }) {
            isCountryPickerSheetOpen = true
            isPickerModeSendCountry = true
        }
        Spacer(modifier = Modifier.padding(16.dp))
        AmountLabelTextView(visibleLeftIcon = true, value = formatNumber(amount), country = receive, {}) {
            isCountryPickerSheetOpen = true
            isPickerModeSendCountry = false
        }

        if(isCountryPickerSheetOpen) {
            CountryPickerSheet(modifier = Modifier.fillMaxWidth().height(60.dp), {
                viewModel.changeCountry(isPickerModeSendCountry, it)
                isCountryPickerSheetOpen = false
            }) {
                isCountryPickerSheetOpen = false
            }
        }
    }
}