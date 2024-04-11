package com.nizk.emv_qrcode
/**
 * File Name: EmvQrCodeDecoder.kt
 * Project: EMV QR Code Decoder Library
 * Description: This class decodes EMV QR codes into structured data. It parses the QR code string,
 * extracts individual data elements, and constructs an MPMEmvQrCodeData object with the parsed information.
 * Author: Mohamed Ayed (engmohammedayed@gmail.com)
 * Created: 5,April 2024
 * Last Updated: 11 April 2024
 * Version: 1.0.0
 * License: MIT License
 * GitHub: https://github.com/mohamedayed/emv_qrcode/
 *
 * Notes:
 * This decoder handles the parsing and mapping of EMV QR code data elements into a structured format.
 * It supports various fields as per the EMV QR Code Specification and provides a utility to extract
 * sub-elements within the merchant account information and additional data fields.
 */

class EmvQrCodeDecoder(private val qrCode: String) {
    private val dataElements: MutableMap<String, String> = mutableMapOf()
    init {
        parseQrCode(qrCode)
    }


    private fun parseQrCode(qrCode:String) {
        var index = 0
        while (index < qrCode.length) {
            val id = qrCode.substringOrNull(index, index + 2) ?: break
            index += 2

            val length = qrCode.substringOrNull(index, index + 2)?.toIntOrNull() ?: break
            index += 2

            val value = qrCode.substringOrNull(index, index + length) ?: break
            index += length

            dataElements[id] = value
        }
    }

    private fun extractSubElement(fieldValue: String, subElementId: String): String? {
        var index = 0
        while (index < fieldValue.length) {
            if (index + 2 > fieldValue.length) return null
            val id = fieldValue.substring(index, index + 2)
            index += 2

            if (index + 2 > fieldValue.length) return null
            val lengthStr = fieldValue.substring(index, index + 2)
            val length = lengthStr.toIntOrNull() ?: return null
            index += 2

            if (index + length > fieldValue.length) return null
            val value = fieldValue.substring(index, index + length)
            index += length

            if (id == subElementId) {
                return value
            }
        }
        return null
    }

    fun decode(): MPMEmvQrCodeData {
        val merchantAccountInformation = MerchantInfoType.values().associateWith { type ->
            getMerchantAccountInformation(type)
        }

        val additionalDataFieldTemplate = MerchantAdditionalDataFieldType.values().associateWith { type ->
            getAdditionalDataFieldTemplate(type)
        }
        val merchantInformationLang = MerchantInformationLanguageType.values().associateWith { type ->

            getMerchantInformationLanguage(type)

        }
        return MPMEmvQrCodeData(
            payloadFormatIndicator = dataElements["00"],
            pointOfInitiationMethod = dataElements["01"],
            merchantAccountInformation = merchantAccountInformation,
            merchantCategoryCode = dataElements["52"],
            transactionCurrency = dataElements["53"],  // Assuming you have a method to convert the numeric code to an alphabetic code
            transactionAmount = dataElements["54"],
            countryCode = dataElements["58"],
            merchantName = dataElements["59"],
            merchantCity = dataElements["60"],
            postalCode = dataElements["61"],
            additionalDataFieldTemplate = additionalDataFieldTemplate,
            merchantInformationLanguage = merchantInformationLang,
            crc = dataElements["63"]
        )
    }


    private fun getMerchantInformationLanguage(merchantInformationLanguageType: MerchantInformationLanguageType):String?{
        val merchantinfoLang = dataElements["64"] ?: return null
        val subElementId = merchantInformationLanguageType.ordinal.toString().padStart(2,'0')
        return extractSubElement(merchantinfoLang,subElementId)
    }


    private fun getMerchantAccountInformation(infoType: MerchantInfoType): String? {
        val merchantInfo = dataElements["26"] ?: return null
        val subElementId = infoType.ordinal.toString().padStart(2,'0')
        return extractSubElement(merchantInfo, subElementId)

    }


    private fun getAdditionalDataFieldTemplate(type: MerchantAdditionalDataFieldType): String? {
        val additionalDataField = dataElements["62"] ?: return null
        val subElementId = type.ordinal.plus(1).toString().padStart(2,'0')
        return extractSubElement(additionalDataField, subElementId)

    }
    private fun String.substringOrNull(startIndex: Int, endIndex: Int): String? =
        if (startIndex < length && endIndex <= length) this.substring(startIndex, endIndex) else null
}
