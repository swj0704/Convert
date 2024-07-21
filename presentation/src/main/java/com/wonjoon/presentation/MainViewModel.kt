package com.wonjoon.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wonjoon.domain.ApiState
import com.wonjoon.domain.model.enums.Country
import com.wonjoon.domain.usecase.ConvertUseCase
import com.wonjoon.domain.usecase.CountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    val convertUseCase: ConvertUseCase,
    val countryUseCase: CountryUseCase,
) : ViewModel(){
    private val _amount = MutableLiveData<Double>()
    val amount : LiveData<Double> by ::_amount

    private val _rate = MutableLiveData<Double>()
    val rate : LiveData<Double> by ::_rate

    private val _date = MutableLiveData<String>("")
    val date : LiveData<String> by ::_date

    private val _send = MutableLiveData<Country>(Country.KR)
    val send : LiveData<Country> by ::_send

    private val _receive = MutableLiveData<Country>(Country.US)
    val receive : LiveData<Country> by ::_receive

    fun changeCountry(isPickerModeSendCountry: Boolean, country: Country){
        if(isPickerModeSendCountry){
            _send.value = country
        } else {
            _receive.value = country
        }
    }

    fun convert(send : String, receive : String, amount : String, isInit: Boolean){
        viewModelScope.launch {
            convertUseCase(send, receive, amount.toLong()).collect{
                if(it is ApiState.Success){
                    if(it.data!!.success){
                        if(isInit) {
                            _rate.value = it.data!!.rate
                            val formatter = DateTimeFormatter.ofPattern("MM-dd.yyyy\na HH:mm:ss")
                            val formattedString: String = it.data!!.date!!.format(formatter)
                            _date.value = formattedString
                        } else {
                            _amount.value = it.data!!.result
                        }
                    }
                }
            }
        }
    }
}