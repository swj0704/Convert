package com.wonjoon.domain.model.enums

enum class Currency(val currency: String, val symbol: String, val base: Long) {
    KRW("원", "₩", 1000L),
    USD("달러", "$", 1L),
    EUR("유로", "€", 1L),
    JPY("엔", "¥", 100L),
    CNY("위안", "¥", 1L),
    VND("동", "₫", 100L),
    GBP("파운드", "£", 1L),
    THB("바트", "฿", 1L),
    PHP("페소", "₱", 1L),
}