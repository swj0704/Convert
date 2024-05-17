package com.wonjoon.domain.repository

import com.wonjoon.domain.model.CountryModel

interface CountryRepository {
    fun getCountries() : List<CountryModel>
}