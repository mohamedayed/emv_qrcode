package com.nizk.emv_qrcode

data class MPMEmvQrCodeData(
    val payloadFormatIndicator: String?,
    val pointOfInitiationMethod: String?,
    val merchantAccountInformation: Map<MerchantInfoType, String?>,
    val merchantCategoryCode: String?,
    val transactionCurrency: String?,
    val transactionAmount: String?,
    val countryCode: String?,
    val merchantName: String?,
    val merchantCity: String?,
    val postalCode: String?,
    val additionalDataFieldTemplate: Map<MerchantAdditionalDataFieldType, String?>,
    val merchantInformationLanguage:Map<MerchantInformationLanguageType,String?>,
    val crc: String?
)