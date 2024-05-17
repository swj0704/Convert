package com.wonjoon.domain.model

import com.wonjoon.domain.model.enums.Currency

interface CountryModel {
    val name: String
    val imageUrl : String
    val currency : Currency
}