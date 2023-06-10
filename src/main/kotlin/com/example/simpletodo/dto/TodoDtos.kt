package com.example.simpletodo.dto

import java.time.LocalDateTime


data class TodoResDto(
    val id:Long,
    val content:String,
    val status: Boolean,
    val createdAt: LocalDateTime,
)