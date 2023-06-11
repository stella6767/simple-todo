package com.example.simpletodo.exception


sealed class AppException(message: String = "") : RuntimeException(message)

class UnSupportedSocialException(message: String) : AppException(message)

