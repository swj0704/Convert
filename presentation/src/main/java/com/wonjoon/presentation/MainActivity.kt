package com.wonjoon.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wonjoon.domain.model.enums.Country
import com.wonjoon.presentation.format.formatNumber
import com.wonjoon.presentation.format.getNumber
import com.wonjoon.presentation.header.HeaderView
import com.wonjoon.presentation.label.AmountLabelTextView
import com.wonjoon.presentation.label.RowLabelTextView
import com.wonjoon.presentation.ui.theme.ConvertTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConvertTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }
}

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

    LaunchedEffect(send, receive) {
        viewModel.convert(send.currency.name, receive.currency.name, receive.currency.base.toString(), true)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderView(send, receive)
        RowLabelTextView("내 적용 환율", "${receive.currency.base}${receive.currency.currency} 당 ${rate}${send.currency.currency}")//1 달러 당 1355 원
        RowLabelTextView("환율 조회 시간", date)
        AmountLabelTextView(visibleLeftIcon = false, value = sendAmount.value, country = send) {
            val number = getNumber(it)
            sendAmount.value = formatNumber(number)
            viewModel.convert(receive.currency.name, send.currency.name, number.toString(), false)
        }
        Spacer(modifier = Modifier.padding(16.dp))
        AmountLabelTextView(visibleLeftIcon = true, value = formatNumber(amount), country = receive) {}
    }
}