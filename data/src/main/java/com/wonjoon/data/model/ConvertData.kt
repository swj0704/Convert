package com.wonjoon.data.model

import com.google.gson.annotations.SerializedName
import com.wonjoon.domain.model.ConvertDataModel
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

data class ConvertData(
    @SerializedName("date")
    val _date : String?,
    @SerializedName("info")
    val _info : Info?,
    @SerializedName("result")
    val _result : Double?,
    @SerializedName("success")
    val _success : Boolean
) : ConvertDataModel{
    override val date: ZonedDateTime?
        get() = ZonedDateTime.parse(_date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    override val rate: Double?
        get() = _info?.rate
    override val result: Double?
        get() = _result
    override val success: Boolean
        get() = _success
}