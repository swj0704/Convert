package com.wonjoon.data.repository

import com.wonjoon.data.model.Country
import com.wonjoon.domain.model.CountryModel
import com.wonjoon.domain.repository.CountryRepository


class CountryRepositoryImpl : CountryRepository{
    override fun getCountries() : List<CountryModel>{
        val countries = ArrayList<CountryModel>()
        countries.add(Country("European Union", "https://flagcdn.com/w320/eu.png", "EUR"))
        countries.add(Country("United States", "https://flagcdn.com/w320/us.png", "USD"))
        countries.add(Country("South Korea", "https://flagcdn.com/w320/kr.png", "KRW"))
        countries.add(Country("Japan", "https://flagcdn.com/w320/jp.png", "JPY"))
        countries.add(Country("China", "https://flagcdn.com/w320/cn.png", "CNY"))
        countries.add(Country("Vietnam", "https://flagcdn.com/w320/vn.png", "VND"))
        countries.add(Country("United Kingdom", "https://flagcdn.com/w320/uk.png", "GBP"))
        countries.add(Country("Thailand", "https://flagcdn.com/w320/th.png", "THB"))
        countries.add(Country("Philippines", "https://flagcdn.com/w320/ph.png", "PHP"))

        return countries
    }
}