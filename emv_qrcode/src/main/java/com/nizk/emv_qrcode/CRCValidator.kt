package com.nizk.emv_qrcode

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