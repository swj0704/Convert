package com.wonjoon.domain.repository

import com.wonjoon.domain.model.enums.Country

interface CountryRepository {
    fun getCountries() : List<Country>
}