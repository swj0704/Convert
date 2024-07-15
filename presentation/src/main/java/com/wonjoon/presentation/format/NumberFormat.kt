package com.wonjoon.presentation.format

import java.text.NumberFormat
import java.text.ParseException
import java.util.Locale

fun getDecimalFormatSymbol() : String {
    return try {
        // 현재 로케일의 소수점 구분 기호 가져오기
        val locale = Locale.getDefault()
        val numberFormat = NumberFormat.getInstance(locale)
        val decimalFormatSymbols = (numberFormat as? java.text.DecimalFormat)?.decimalFormatSymbols
        val decimalSeparator = decimalFormatSymbols?.decimalSeparator ?: '.'
        decimalSeparator.toString()
    } catch (e : Exception){
        "."
    }
}

fun getNumber(numberString: String) : Long{
    return try {
        // 현재 로케일의 소수점 구분 기호 가져오기
        val locale = Locale.getDefault()
        val numberFormat = NumberFormat.getInstance(locale)
        val decimalFormatSymbols = (numberFormat as? java.text.DecimalFormat)?.decimalFormatSymbols
        val decimalSeparator = decimalFormatSymbols?.decimalSeparator ?: '.'
        val cleanedNumberString = numberString.replace("[^\\d$decimalSeparator]".toRegex(), "")
        cleanedNumberString.replace(decimalSeparator, '.').toLong()
    } catch (e: NumberFormatException) {
        // 숫자 형식이 올바르지 않은 경우 예외 처리
        0
    } catch (e: ParseException) {
        // 숫자 형식이 올바르지 않은 경우 예외 처리
        0
    }
}

fun formatNumber(number: Number): String {
    return try {
        val locale = Locale.getDefault()
        val numberFormat = NumberFormat.getInstance(locale)
        numberFormat.format(number)
    } catch (e: NumberFormatException) {
        // 숫자 형식이 올바르지 않은 경우 예외 처리
        "Invalid number format"
    } catch (e: ParseException) {
        // 숫자 형식이 올바르지 않은 경우 예외 처리
        "Invalid number format"
    }
}