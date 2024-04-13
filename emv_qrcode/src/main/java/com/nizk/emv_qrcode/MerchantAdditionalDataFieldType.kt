package com.nizk.emv_qrcode
/**
 * File Name: MerchantAdditionalDataFieldType.kt
 * Project: EMV QR Code Decoder Library
 * Description: Defines the types of additional data fields that can be present in an EMV QR code.
 * Each field type represents a specific piece of merchant information that can be included in the QR code.
 * Author: Mohamed Ayed (engmohammedayed@gmail.com)
 * Created: 5, April 2024
 * Last Updated: 11, April 2024
 * Version: 1.0.0
 * License: MIT License
 * GitHub: https://github.com/mohamedayed/emv_qrcode/
 *
 * Notes:
 * The EMV QR Code specification allows for various additional data fields to be included, such as
 * bill numbers, mobile numbers, and reference labels. This enum encapsulates these field types, enabling
 * structured parsing and representation of the additional data segment of the EMV QR codes.
 */
enum class MerchantAdditionalDataFieldType {
    BILL_NUMBER,
    MOBILE_NUMBER,
    STORE_LABEL,
    LOYALTY_NUMBER,
    REFERENCE_LABEL,
    CUSTOMER_LABEL,
    TERMINAL_LABEL,
    PURPOSE_OF_TRANSACTION
}
