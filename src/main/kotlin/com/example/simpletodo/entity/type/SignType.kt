package com.example.simpletodo.entity.type

import com.fasterxml.jackson.annotation.JsonCreator

enum class SignType(
    val clientName: String
) {
    FACEBOOK("Facebook"),
    GOOGLE("Google"),
    GITHUB("Github"),

    ;

    companion object {
        @JsonCreator
        fun from(str: String): SignType? {
            return SignType.values().firstOrNull {
                it.name == str.uppercase()
            }
        }
    }
}