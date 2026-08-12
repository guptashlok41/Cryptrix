# 🔐 Cryptrix

Secure Message Encryption Android App built using **Kotlin** and **AES-256 Encryption**.

Cryptrix allows users to securely encrypt and decrypt messages using a password. The encryption key is derived using **PBKDF2WithHmacSHA256**, while **AES-GCM** provides authenticated encryption with random Salt and IV for every message.

---

## ✨ Features

- 🔒 AES-256 Encryption
- 🛡️ AES-GCM Authenticated Encryption
- 🔑 PBKDF2-HMAC-SHA256 Key Derivation
- 🎲 Random Salt Generation
- 🎲 Random IV Generation
- 📋 Copy Encrypted Text
- 📤 Share Encrypted Text
- 👁️ Password Visibility Toggle
- ✅ Material Design UI
- ⚡ Snackbar Feedback Messages

---

## 🛠️ Tech Stack

- Kotlin
- Android SDK
- Material Components
- AES/GCM/NoPadding
- PBKDF2WithHmacSHA256
- Android Clipboard API
- Android Share Intent

---

## 🔐 Security

Cryptrix follows modern encryption practices.

- Encryption Algorithm: **AES-256**
- Mode: **AES/GCM/NoPadding**
- Key Derivation: **PBKDF2WithHmacSHA256**
- Iterations: **65,536**
- Salt Size: **16 Bytes**
- IV Size: **12 Bytes**
- Authentication Tag: **128-bit**

Each encryption generates a new random Salt and IV, ensuring that encrypting the same message twice produces different ciphertext.

---

## 🚀 How to Use

1. Enter your message.
2. Enter a password.
3. Tap **Encrypt**.
4. Copy or Share the encrypted text.
5. Paste the encrypted text back.
6. Enter the same password.
7. Tap **Decrypt**.

---

# 📱 Screenshots

## 🏠 Home Screen

<img width="300" height="600" alt="WhatsApp Image 2026-08-07 at 3 04 29 PM" src="https://github.com/user-attachments/assets/d7a58e27-6204-44f0-b33e-010cb3c3b043" />


---

## 🔒 Encrypt Message

<img width="300" height="600" alt="WhatsApp Image 2026-08-07 at 3 05 03 PM" src="https://github.com/user-attachments/assets/4412db34-85e6-4b52-800f-b4ffdda4cb9d" />


---

## 📋 Copy Encrypted Text

<img width="300" height="600" alt="WhatsApp Image 2026-08-07 at 3 06 48 PM" src="https://github.com/user-attachments/assets/162f09aa-e890-46c1-b353-d7f5a257245f" />


---

## 📤 Share Encrypted Text

<img width="300" height="600" alt="WhatsApp Image 2026-08-07 at 3 11 06 PM" src="https://github.com/user-attachments/assets/ec6cabf4-662b-48b1-bb3d-0618487affc3" />
<img width="300" height="600" alt="WhatsApp Image 2026-08-07 at 3 11 06 PM (1)" src="https://github.com/user-attachments/assets/91782cbb-1ea4-4020-ba45-63b5efa2d0f6" />



---

## 🔓 Decrypt Message

<img width="300" height="600" alt="WhatsApp Image 2026-08-07 at 3 08 04 PM" src="https://github.com/user-attachments/assets/18c659f0-a5d6-4b6b-88e0-92209cfcbe6d" />


---

## 📂 Project Structure

```
Cryptrix
│
├── app
│
├── screenshots
│
└── README.md
```

---

## 🔮 Future Improvements

- 🌙 Dark Mode
- 📜 Encryption History
- 📱 QR Code Sharing
- 📂 Export Encrypted Text
- ☁️ Cloud Backup
- 🔐 Biometric Authentication

---

## 👨‍💻 Author

**Shlok Gupta**

If you like this project, consider giving it a ⭐ on GitHub!
