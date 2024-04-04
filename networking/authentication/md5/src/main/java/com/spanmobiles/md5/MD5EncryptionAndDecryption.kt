package com.spanmobiles.md5

import java.security.MessageDigest
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class MD5EncryptionAndDecryption(
    private val secretKey: String,
    private val transformation: String = "AES/ECB/PKCS7Padding"
) {

    fun encryption(unencryptedString: String?): String? {
        unencryptedString ?: return ""
        return try {
            val md = MessageDigest.getInstance("MD5")
            val digestOfPassword = md.digest(secretKey.toByteArray())
            val keyBytes = digestOfPassword.copyOf(16)
            val secretKey = SecretKeySpec(keyBytes, "AES")
            val cipher = Cipher.getInstance(transformation)
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            String(Base64.getEncoder().encode(cipher.doFinal(unencryptedString.toByteArray())))
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun decryption(encryptedString: String?): String? {
        encryptedString ?: return ""
        return try {
            val message = Base64.getDecoder().decode(encryptedString.toByteArray())
            val md = MessageDigest.getInstance("MD5")
            val digestOfPassword = md.digest(secretKey.toByteArray())
            val keyBytes = digestOfPassword.copyOf(16)
            val secretKey = SecretKeySpec(keyBytes, "AES")
            val decipher = Cipher.getInstance(transformation)
            decipher.init(Cipher.DECRYPT_MODE, secretKey)
            String(decipher.doFinal(message))
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
