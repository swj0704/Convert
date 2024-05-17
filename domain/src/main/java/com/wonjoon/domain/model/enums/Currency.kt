package com.wonjoon.domain.model.enums

enum class Currency(val currency: String, val symbol: String) {
    KRW("원", "₩"),
    USD("달러", "$"),
    EUR("유로", "€"),
    JPY("엔", "¥"),
    CNY("원", "¥"),
    VND("동", "₫"),
    GBP("파운드", "£"),
    THB("바트", "฿"),
    PHP("페소", "₱"),
}