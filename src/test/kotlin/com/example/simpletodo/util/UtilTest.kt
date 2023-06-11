package com.example.simpletodo.util

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor
import org.junit.jupiter.api.Test


class UtilTest {

    @Test
    fun jasyptTest() {


        val gitHubSecret = "postgres"
        val googleSecret = "1234"
        val facebookSecret = "1234"


        val encryptGithub = jasyptEncrypt(gitHubSecret)
        val encryptGoogle = jasyptEncrypt(googleSecret)
        val encryptFacebook = jasyptEncrypt(facebookSecret)


        System.out.println("encryptGithub : " + encryptGithub)
        System.out.println("encryptGoogle" + encryptGoogle)
        System.out.println("encryptFacebook" + encryptFacebook)


    }

    private fun jasyptEncrypt(input: String): String? {
        val key = "1234"
        val encryptor = StandardPBEStringEncryptor()
        encryptor.setAlgorithm("PBEWithMD5AndDES")
        encryptor.setPassword(key)
        return encryptor.encrypt(input)
    }

    private fun jasyptDecryt(input: String): String? {
        val key = "1234"
        val encryptor = StandardPBEStringEncryptor()
        encryptor.setAlgorithm("PBEWithMD5AndDES")
        encryptor.setPassword(key)
        return encryptor.decrypt(input)
    }


}