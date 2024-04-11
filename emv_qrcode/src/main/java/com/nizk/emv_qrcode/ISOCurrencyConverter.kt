package com.nizk.emv_qrcode

class ISOCurrencyConverter {
    companion object {
        private val currencyMap = mapOf(
            "008" to "ALL",
            "012" to "DZD",
            "032" to "ARS",
            "036" to "AUD",
            "050" to "BDT",
            "051" to "AMD",
            "818" to "EGP",
            "840" to "USD",
            "978" to "EUR",
            "826" to "GBP",
            "392" to "JPY",
            "156" to "CNY",
            "643" to "RUB",
            "356" to "INR",
            "410" to "KRW",
            "986" to "BRL",
            "124" to "CAD",
            "752" to "SEK",
            "208" to "DKK",
            "578" to "NOK",
        )

        fun getCurrencyName(isoNumericCode: String): String {
            return currencyMap[isoNumericCode] ?: "Unknown Currency"
        }
    }
}