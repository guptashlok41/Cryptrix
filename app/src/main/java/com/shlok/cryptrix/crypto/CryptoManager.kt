package com.shlok.cryptrix.crypto
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec
import android.util.Base64

class CryptoManager {
    private companion object {
        const val AES_MODE = "AES/GCM/NoPadding"
        const val KEY_SIZE = 256
        const val ITERATIONS = 65536
        const val SALT_LENGTH = 16
        const val IV_LENGTH = 12
        const val TAG_LENGTH = 128
    }
    private fun generateKey(password: String, salt: ByteArray): SecretKeySpec {
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        val spec = PBEKeySpec(
            password.toCharArray(),
            salt,
            ITERATIONS,
            KEY_SIZE
        )

        val secret = factory.generateSecret(spec).encoded
        return SecretKeySpec(secret, "AES")
    }
    private fun generateSalt(): ByteArray {
        return ByteArray(SALT_LENGTH).apply {
            SecureRandom().nextBytes(this)
        }
    }

    private fun generateIV(): ByteArray {
        return ByteArray(IV_LENGTH).apply {
            SecureRandom().nextBytes(this)
        }
    }
    fun encrypt(message: String,password: String): String {
        val salt = generateSalt()
        val iv = generateIV()
        val key = generateKey(password, salt)
        val cipher = Cipher.getInstance(AES_MODE)
        val spec = GCMParameterSpec(TAG_LENGTH, iv)
        cipher.init(Cipher.ENCRYPT_MODE, key, spec)
        val cipherText = cipher.doFinal(message.toByteArray(Charsets.UTF_8))
        val combined = salt + iv + cipherText
        return Base64.encodeToString(combined, Base64.NO_WRAP)
    }
    fun decrypt(encryptedMessage: String,password: String): String {
        val combined = Base64.decode(encryptedMessage, Base64.NO_WRAP)
        val salt=combined.copyOfRange(0, SALT_LENGTH)
        val iv=combined.copyOfRange(SALT_LENGTH, SALT_LENGTH + IV_LENGTH)
        val encrypted=combined.copyOfRange(SALT_LENGTH + IV_LENGTH, combined.size)
        val key = generateKey(password, salt)
        val cipher = Cipher.getInstance(AES_MODE)
        val spec = GCMParameterSpec(TAG_LENGTH, iv)
        cipher.init(Cipher.DECRYPT_MODE, key, spec)
        val plainText = cipher.doFinal(encrypted)
        return String(plainText, Charsets.UTF_8)
    }
}