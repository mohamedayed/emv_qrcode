package com.nizk.emv_qrcode
/**
 * File Name: MPMEmvQrCodeData.kt
 * Project: EMV QR Code Decoder Library
 * Description: Data class representing the structured data extracted from an EMV QR code. It contains
 * all the essential elements defined in the EMV QR Code Specification, such as merchant information,
 * transaction details, and additional data fields.
 * Author: Mohamed Ayed (engmohammedayed@gmail.com)
 * Created: 5, April 2024
 * Last Updated: 11, April 2024
 * Version: 1.0.0
 * License: MIT License
 * GitHub: https://github.com/mohamedayed/emv_qrcode/
 *
 * Notes:
 * This class serves as the primary data model for the decoded EMV QR code content, providing a
 * convenient and accessible structure for further processing or analysis. It encapsulates various
 * elements from the QR code, including both the standard EMV fields and any additional merchant-specific
 * data, thereby offering a comprehensive view of the scanned QR code data.
 */
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