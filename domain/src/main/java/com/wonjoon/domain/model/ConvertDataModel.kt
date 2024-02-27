package com.wonjoon.domain.model

import java.time.ZonedDateTime

interface ConvertDataModel {
    val date : ZonedDateTime?
    val rate : Double?
    val result : Double?
    val success : Boolean
}