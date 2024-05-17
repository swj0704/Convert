package com.wonjoon.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.wonjoon.presentation.header.HeaderView
import com.wonjoon.presentation.label.RowLabelTextView
import com.wonjoon.presentation.ui.theme.ConvertTheme

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

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderView()
        RowLabelTextView("내 적용 환율", "1300원")
    }
}