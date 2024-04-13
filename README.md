# EMV QR Code Decoder Library
> The EMV QR Code Decoder Library is a Kotlin-based utility that decodes EMV QR codes into structured data.
> It provides classes and enums to parse the QR code string, extract individual data elements, and construct an object with the parsed information.

##Compatibility : Our library now supports Android and any language that runs on the JVM

## Features
 - Decode EMV QR codes into structured data
 - Parse and extract individual data elements
 - Support for various fields as per the EMV QR Code Specification
 - Utility functions for data validation and CRC calculation

## Installation

```
repositories {
			maven { url 'https://jitpack.io' }
		}
```
```
dependencies {
	        implementation 'com.github.mohamedayed:emv_qrcode:1.0.1'
	}
```
### Maven 
```
<dependency>
  <groupId>com.nizk.mohamedayed</groupId>
  <artifactId>emv-qrcode</artifactId>
  <version>1.0.0</version>
</dependency>
```
## Usage

## Scanning QR Codes
This library is designed to decode EMV QR codes into structured data. You can scan the QR code using any QR code reader library available for Android. Here are a few popular libraries you can use:
- [ZXing Android Embedded](https://github.com/journeyapps/zxing-android-embedded): A popular QR code scanning library for Android.
- [Barcode Scanner by ZXing Team](https://github.com/zxing/zxing): The official ZXing (Zebra Crossing) library for barcode and QR code scanning.
- [Google Mobile Vision](https://developers.google.com/vision/android/barcodes-overview): Part of Google Play services, provides barcode and QR code scanning capabilities.


## EMV QR Code Decoder
Once you have scanned the QR code and obtained the `qrCodeString`, you can create an instance of the `EmvQrCodeDecoder` as follows:

```
// Create an instance of the EMV QR Code Decoder
val decoder = EmvQrCodeDecoder(qrCodeString)

// Decode the QR code and get the structured data
val decodedData = decoder.decode()

// Access individual data elements
        val decoder = EmvQrCodeDecoder(Constants.qrcode)
        val decodedData = decoder.decode()

// Access the decoded data directly from the `decodedData` variable
        val countryCode = decodedData.countryCode
        val merchantCity = decodedData.merchantCity
        val merchantCategoryCode = decodedData.merchantCategoryCode
        val merchantName = decodedData.merchantName
        val postalCode = decodedData.postalCode
        val transactionAmount = decodedData.transactionAmount
        val transactionCurrency = decodedData.transactionCurrency

// Accessing merchant account information
        val merchantAccountInfo = decodedData.merchantAccountInformation
        val merchantId = merchantAccountInfo.get(MerchantInfoType.MERCHANT_ID)
        val networkId = merchantAccountInfo.get(MerchantInfoType.NETWORK_ID)

// Accessing merchant information in alternative Preference language
        val merchantInformationLanguageInfo = decodedData.merchantInformationLanguage
        val merchantCityAltLang = merchantInformationLanguageInfo.get(MerchantInformationLanguageType.MERCHANT_CITY_ALTER_LANG)
        val languagePreference = merchantInformationLanguageInfo.get(MerchantInformationLanguageType.LANGUAGE_PREF)
        val merchantNameAltLang = merchantInformationLanguageInfo.get(MerchantInformationLanguageType.MERCHANT_NAME_ALTER_LANG)

// Accessing additional data fields
        val additionalDataField = decodedData.additionalDataFieldTemplate
        val loyaltyNumber = additionalDataField.get(MerchantAdditionalDataFieldType.LOYALTY_NUMBER)
        val billNumber = additionalDataField.get(MerchantAdditionalDataFieldType.BILL_NUMBER)
        val customerLabel = additionalDataField.get(MerchantAdditionalDataFieldType.CUSTOMER_LABEL)
        val mobileNumber = additionalDataField.get(MerchantAdditionalDataFieldType.MOBILE_NUMBER)
        val referenceLabel = additionalDataField.get(MerchantAdditionalDataFieldType.REFERENCE_LABEL)
        val purposeOfTransaction = additionalDataField.get(MerchantAdditionalDataFieldType.PURPOSE_OF_TRANSACTION)
        val storeLabel = additionalDataField.get(MerchantAdditionalDataFieldType.STORE_LABEL)
        val terminalLabel = additionalDataField.get(MerchantAdditionalDataFieldType.TERMINAL_LABEL)
```
## CRC Validator

```
// Validate an EMV QR code string using CRC
val isValid = CRCValidator.validate(qrCodeString)

if (isValid) {
    println("QR code is valid.")
} else {
    println("QR code is invalid.")
}
```
### Update: 
Our library now supports decoding of Merchant Presented Mode (MPM) EMV QR codes, providing robust and efficient tools for handling QR code payments in various merchant scenarios. Looking ahead, we are excited to announce that in upcoming releases, we will extend our support to include Consumer Presented Mode (CPM). This enhancement will broaden our library's applicability, making it even more versatile for different payment environments.
![MPM](https://github.com/mohamedayed/emv_qrcode/assets/7974089/9a736ceb-4431-46fe-bed0-f892ff5f6a42)


## Contributing

Contributions to this library are welcome! If you encounter any issues or have suggestions for improvements, 
please open an issue or submit a pull request on GitHub.

## License

This library is released under the MIT License. See LICENSE for more details.

## Author
 - Mohamed Ayed 


