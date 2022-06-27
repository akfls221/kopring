package com.example.kopring.exception.enum

enum class Status(
    var code: Int? = null,
    var dec: String? = null
) {
    ParameterEx(111, "입력값이 잘못 되었습니다."),
    ExistEx(222, "이미 존재하는 블랙리스트 입니다."),
    NoExistEx(333, "존재하지 않는 블랙리스트 입니다.");

}