package com.nizk.emv_qrcode
/**
 * File Name: CRCValidator.kt
 * Project: EMV QR Code Decoder Library
 * Description: This class provides functionality to validate the CRC (Cyclic Redundancy Check)
 * of an EMV QR code string. It ensures the integrity and authenticity of the QR code data
 * by comparing the calculated CRC value against the one present in the QR code.
 * Author: Mohamed Ayed (engmohammedayed@gmail.com)
 * Created: 8, April 2024
 * Last Updated: 11, April 2024
 * Version: 1.0.0
 * License: MIT License
 * GitHub: https://github.com/mohamedayed/emv_qrcode/
 *
 * Notes:
 * The CRC validation is an essential part of processing EMV QR codes, ensuring that the data
 * has not been altered or corrupted. This class implements the standard CRC-16 CCITT algorithm
 * to calculate and validate the CRC value of the QR code content. It is designed to be used
 * alongside the EmvQrCodeDecoder to verify the data integrity before decoding.
 */
class CRCValidator {
    companion object {
        private const val CRC_LENGTH = 4

        fun validate(qrCode: String): Boolean {
            val crcValueFromCode = qrCode.takeLast(CRC_LENGTH)
            val dataToValidate = qrCode.dropLast(CRC_LENGTH)

            return calculateCrc(dataToValidate).equals(crcValueFromCode, ignoreCase = true)
        }

        private fun calculateCrc(data: String): String {
            var crc = 0xFFFF
            val polynomial = 0x1021

            data.toByteArray().forEach { byte ->
                var b = byte.toInt()
                for (i in 0 until 8) {
                    val bit = ((b shr (7 - i) and 1) == 1)
                    val c15 = ((crc shr 15 and 1) == 1)
                    crc = crc shl 1
                    if (c15 xor bit) crc = crc xor polynomial
                }
            }
            crc = crc and 0xffff

            return crc.toString(16).uppercase().padStart(CRC_LENGTH, '0')
        }
    }
}