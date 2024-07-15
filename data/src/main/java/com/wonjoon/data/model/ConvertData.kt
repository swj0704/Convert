package com.wonjoon.data.model

import com.google.gson.annotations.SerializedName
import com.wonjoon.domain.model.ConvertDataModel
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

data class ConvertData(
    @SerializedName("info")
    val _info : Info?,
    @SerializedName("result")
    val _result : Double?,
    @SerializedName("success")
    val _success : Boolean
) : ConvertDataModel{
    override val date: ZonedDateTime?
        get() = (_info?.timestamp?.let {
            val instant = Instant.ofEpochMilli(it * 1000)
            ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())
       })
    override val rate: Double?
        get() = _info?.rate
    override val result: Double?
        get() = _result
    override val success: Boolean
        get() = _success
}