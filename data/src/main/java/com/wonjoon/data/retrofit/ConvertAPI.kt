package com.wonjoon.data.retrofit

import com.wonjoon.data.model.ConvertData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ConvertAPI {
    @GET("convert")
    suspend fun convert(
        @Header("apikey") apiKey : String = "lct2wwO59poBWLatZcl3wIZ8VP1GoMgS",
        @Query("to") sendCountry : String,
        @Query("from") receiveCountry : String,
        @Query("amount") amount : Long
    ) : Response<ConvertData>
}