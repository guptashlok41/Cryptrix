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

![](screenshots/encrypt.png)

---

## 🔓 Decrypt Message

![](screenshots/decrypt.png)

---

## 📋 Copy Encrypted Text

![](screenshots/copy.png)

---

## 📤 Share Encrypted Text

![](screenshots/share.png)

---

## 📂 Project Structure

```
Cryptrix
│
├── app
│
├── screenshots
│   ├── home.png
│   ├── encrypt.png
│   ├── decrypt.png
│   ├── copy.png
│   └── share.png
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
