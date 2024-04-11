# EMV QR Code Decoder Library
> The EMV QR Code Decoder Library is a Kotlin-based utility that decodes EMV QR codes into structured data.
> It provides classes and enums to parse the QR code string, extract individual data elements, and construct an object with the parsed information.


## Features
 - Decode EMV QR codes into structured data
 - Parse and extract individual data elements
 - Support for various fields as per the EMV QR Code Specification
 - Utility functions for data validation and CRC calculation

## Installation
   
### Maven 
```
<dependency>
    <groupId>com.nizk</groupId>
    <artifactId>emvqrcode</artifactId>
    <version>1.0.0</version>
   </dependency>
```
## Usage
## EMV QR Code Decoder

```
// Create an instance of the EMV QR Code Decoder
val decoder = EmvQrCodeDecoder(qrCodeString)

// Decode the QR code and get the structured data
val decodedData = decoder.decode()

// Access individual data elements
val merchantName = decodedData.merchantName
val transactionAmount = decodedData.transactionAmount
// Add more data access examples here
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

## Contributing

Contributions to this library are welcome! If you encounter any issues or have suggestions for improvements, 
please open an issue or submit a pull request on GitHub.

## License

This library is released under the MIT License. See LICENSE for more details.

## Author
 - Mohamed Ayed 


