package com.wonjoon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wonjoon.domain.ApiState
import com.wonjoon.domain.usecase.ConvertUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    val convertUseCase: ConvertUseCase
) : ViewModel(){
    private val _amount = MutableLiveData<Double>()
    val amount : LiveData<Double> by ::_amount

    private val _rate = MutableLiveData<Double>()
    val rate : LiveData<Double> by ::_rate

    private val _date = MutableLiveData<String>("")
    val date : LiveData<String> by ::_date

    fun convert(send : String, receive : String, amount : String){
        viewModelScope.launch {
            convertUseCase(send, receive, amount.toLong()).collect{
                if(it is ApiState.Success){
                    if(it.data!!.success){
                        _amount.value = it.data!!.result
                        _rate.value = it.data!!.rate
                        val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z")
                        val formattedString: String = it.data!!.date!!.format(formatter)
                        _date.value = formattedString
                    }
                }
            }
        }
    }
}