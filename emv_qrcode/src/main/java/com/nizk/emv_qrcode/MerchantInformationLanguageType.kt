package com.nizk.emv_qrcode
/**
 * File Name: MerchantInformationLanguageType.kt
 * Project: EMV QR Code Decoder Library
 * Description: Enumerates the types of merchant information language fields found in EMV QR codes.
 * This includes the primary language preference, and alternate language information for the merchant's name
 * and city. These types facilitate handling multilingual merchant data in QR codes.
 * Author: Mohamed Ayed (engmohammedayed@gmail.com)
 * Created: 5, April 2024
 * Last Updated: 11, April 2024
 * Version: 1.0.0
 * License: MIT License
 * GitHub: https://github.com/mohamedayed/emv_qrcode/
 *
 * Notes:
 * This enumeration is essential for decoding and representing the language-specific information
 * contained in EMV QR codes. It allows for a structured approach to extracting and managing
 * multilingual data, ensuring comprehensive support for international merchant information.
 */
enum class MerchantInformationLanguageType{
    LANGUAGE_PREF,
    MERCHANT_NAME_ALTER_LANG,
    MERCHANT_CITY_ALTER_LANG

}