package com.wonjoon.domain.usecase

import com.wonjoon.domain.ApiState
import com.wonjoon.domain.model.ConvertDataModel
import com.wonjoon.domain.repository.ConvertRepository
import kotlinx.coroutines.flow.Flow

class ConvertUseCase(val repository: ConvertRepository) {
    suspend operator fun invoke(sendCountry : String, receiveCountry : String, amount : Long) : Flow<ApiState<ConvertDataModel>>{
        return repository.convert(sendCountry, receiveCountry, amount)
    }
}