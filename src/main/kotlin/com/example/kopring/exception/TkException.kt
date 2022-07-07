package com.example.kopring.exception

import org.springframework.http.HttpStatus

data class ResponseError(
    val code: Int? = null,
    val dec: String? = null
)

class TkException(
    val status: HttpStatus,
    val code: Int? = null,
    override val message: String? = null
) : RuntimeException()