# Java-RSA

A simple Java implementation of RSA encryption and decryption using the Java Cryptography Architecture (JCA).

## Overview

This project provides a straightforward RSA encryption/decryption utility that demonstrates:
- RSA key pair generation
- Encrypting plaintext using a public key
- Decrypting ciphertext using a private key
- Base64 encoding/decoding for ciphertext handling

## Features

- **Key Generation**: Generates 1024-bit RSA key pairs using `SecureRandom`
- **Encryption**: Encrypts byte arrays using a public key and returns Base64-encoded ciphertext
- **Decryption**: Decrypts Base64-encoded ciphertext using a private key

## Requirements

- Java 8 or higher

## Usage

### Running the Example

Compile and run the `RSA.java` file:

```bash
cd src
javac RSA.java
java RSA
```

### Using in Your Code

```java
import java.security.KeyPair;

// Generate a key pair
KeyPair keys = RSA.generateRSAKeyPair();

// Encrypt a message
String encrypted = RSA.encrypt(keys.getPublic(), "Hello, World!".getBytes());

// Decrypt the message
String decrypted = RSA.decrypt(keys.getPrivate(), encrypted);
```

## API Reference

### `generateRSAKeyPair()`
Generates a new 1024-bit RSA key pair.

**Returns:** `KeyPair` - The generated public/private key pair

### `encrypt(PublicKey publicKey, byte[] plainText)`
Encrypts plaintext bytes using the provided public key.

**Parameters:**
- `publicKey` - The RSA public key for encryption
- `plainText` - The bytes to encrypt

**Returns:** `String` - Base64-encoded ciphertext

### `decrypt(PrivateKey privateKey, String cipherText)`
Decrypts Base64-encoded ciphertext using the provided private key.

**Parameters:**
- `privateKey` - The RSA private key for decryption
- `cipherText` - Base64-encoded ciphertext

**Returns:** `String` - The decrypted plaintext

## Security Note

⚠️ **Important:** This implementation uses a 1024-bit key size for demonstration purposes only. **Do not use 1024-bit keys in production** as they are considered insecure by current standards. For production applications, use at least 2048-bit keys, with 3072-bit or 4096-bit keys recommended for new applications requiring long-term security.

## License

This project is open source and available for use and modification.
