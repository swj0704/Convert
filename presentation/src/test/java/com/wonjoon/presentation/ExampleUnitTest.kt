package com.wonjoon.presentation

import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat
import java.text.ParseException
import java.util.Locale

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    fun formatNumber(numberString: String): String {
        return try {
            // 현재 로케일의 소수점 구분 기호 가져오기
            val locale = Locale.getDefault()
            val numberFormat = NumberFormat.getInstance(locale)
            val decimalFormatSymbols = (numberFormat as? java.text.DecimalFormat)?.decimalFormatSymbols
            val decimalSeparator = decimalFormatSymbols?.decimalSeparator ?: '.'

            // 숫자 문자열에서 소수점 구분 기호를 제외한 모든 특수문자 제거
            val cleanedNumberString = numberString.replace("[^\\d$decimalSeparator]".toRegex(), "")

            // 문자열을 숫자로 변환
            val number = cleanedNumberString.replace(decimalSeparator, '.').toDouble()

            // 디폴트 로케일을 사용하여 숫자를 포맷팅
            numberFormat.format(number)
        } catch (e: NumberFormatException) {
            // 숫자 형식이 올바르지 않은 경우 예외 처리
            "Invalid number format"
        } catch (e: ParseException) {
            // 숫자 형식이 올바르지 않은 경우 예외 처리
            "Invalid number format"
        }
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(formatNumber("10,000,0000.01"), "100,000,000.01")
    }
}