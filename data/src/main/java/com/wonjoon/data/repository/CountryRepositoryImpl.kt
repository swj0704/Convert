package com.wonjoon.data.repository

import com.wonjoon.domain.model.enums.Country
import com.wonjoon.domain.repository.CountryRepository


class CountryRepositoryImpl : CountryRepository{
    override fun getCountries(): List<Country> {
        return listOf(
            Country.US,
            Country.KR,
            Country.EU,
            Country.UK,
            Country.VN,
            Country.JP,
            Country.PH,
            Country.CN,
            Country.TH,
        )
    }
}