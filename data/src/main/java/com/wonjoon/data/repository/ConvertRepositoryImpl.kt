package com.wonjoon.data.repository

import com.wonjoon.data.retrofit.ConvertAPI
import com.wonjoon.domain.ApiState
import com.wonjoon.domain.model.ConvertDataModel
import com.wonjoon.domain.repository.ConvertRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

class ConvertRepositoryImpl(val api : ConvertAPI) : ConvertRepository {
    override suspend fun convert(
        sendCountry: String,
        receiveCountry: String,
        amount: Long
    ): Flow<ApiState<ConvertDataModel>>  = flow{
        try{
            val response = api.convert(sendCountry = sendCountry, receiveCountry = receiveCountry, amount = amount)
            if(response.isSuccessful){
                response.body()?.let {
                    emit(
                        ApiState.Success(
                            it as ConvertDataModel
                        )
                    )
                }
            } else {
                try {
                    emit(ApiState.Error(response.errorBody()!!.string()))
                }   catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        } catch (e : Exception){
            emit(ApiState.Error(e.message ?: ""))
        } as Unit
    }.flowOn(Dispatchers.IO)

}