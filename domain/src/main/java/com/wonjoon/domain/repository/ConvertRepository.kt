package com.wonjoon.domain.repository

import com.wonjoon.domain.ApiState
import com.wonjoon.domain.model.ConvertDataModel
import kotlinx.coroutines.flow.Flow

interface ConvertRepository {
    suspend fun convert(sendCountry : String, receiveCountry : String, amount : Long) : Flow<ApiState<ConvertDataModel>>
}