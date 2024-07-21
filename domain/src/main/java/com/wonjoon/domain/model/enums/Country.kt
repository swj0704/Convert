package com.wonjoon.domain.model.enums

enum class Country(val countryName: String, val imageUrl: String, val currency: Currency) {
    EU("European Union", "https://flagcdn.com/w320/eu.png", Currency.EUR),
    US("United States", "https://flagcdn.com/w320/us.png", Currency.USD),
    KR("South Korea", "https://flagcdn.com/w320/kr.png", Currency.KRW),
    JP("Japan", "https://flagcdn.com/w320/jp.png", Currency.JPY),
    CN("China", "https://flagcdn.com/w320/cn.png", Currency.CNY),
    VN("Vietnam", "https://flagcdn.com/w320/vn.png", Currency.VND),
    UK("United Kingdom", "https://flagcdn.com/w320/gb.png", Currency.GBP),
    TH("Thailand", "https://flagcdn.com/w320/th.png", Currency.THB),
    PH("Philippines", "https://flagcdn.com/w320/ph.png", Currency.PHP),
}