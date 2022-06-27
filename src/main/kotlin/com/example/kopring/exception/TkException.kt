package com.example.kopring.exception

data class ResponseError(
    val code: Int? = null,
    val dec: String? = null
)

class TkException(
    val code: Int? = null,
    val dec: String? = null,
    override val message: String? = null
) : RuntimeException()