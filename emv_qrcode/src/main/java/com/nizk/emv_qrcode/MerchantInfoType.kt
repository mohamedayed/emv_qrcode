package com.nizk.emv_qrcode
/**
 * File Name: MerchantInfoType.kt
 * Project: EMV QR Code Decoder Library
 * Description: Enumerates the types of merchant information identifiers within an EMV QR code.
 * This includes the merchant's unique identifier and the network identifier, facilitating the categorization
 * and retrieval of merchant-specific details in the QR code.
 * Author: Mohamed Ayed (engmohammedayed@gmail.com)
 * Created: 5, April 2024
 * Last Updated: 11, April 2024
 * Version: 1.0.0
 * License: MIT License
 * GitHub: https://github.com/mohamedayed/emv_qrcode/
 *
 * Notes:
 * This enumeration is crucial for distinguishing between different types of merchant identifiers
 * within the QR code data. It aids in the accurate parsing and representation of the merchant's
 * account information, enhancing the decoding process's robustness and specificity.
 */

enum class MerchantInfoType {
    MERCHANT_ID, NETWORK_ID
}