package com.wonjoon.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wonjoon.domain.ApiState
import com.wonjoon.domain.usecase.ConvertUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val convertUseCase: ConvertUseCase
) : ViewModel(){

    fun convert(send : String, receive : String, amount : String){
        viewModelScope.launch {
            convertUseCase(send, receive, amount.toLong()).collect{
                if(it is ApiState.Success){
                    it.data!!
                }
            }
        }
    }
}